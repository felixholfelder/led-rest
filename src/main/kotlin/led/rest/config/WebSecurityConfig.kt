package led.rest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain

@Configuration
class WebSecurityConfig {
  @Bean
  fun webSecurityCustomizer() =
    WebSecurityCustomizer { web -> web.ignoring().requestMatchers("/api/modules/address", "/actuator**") }

  @Bean
  @Throws(Exception::class)
  fun filterChain(http: HttpSecurity): SecurityFilterChain =
    http.authorizeHttpRequests { auth -> auth.anyRequest().authenticated() }.httpBasic(withDefaults()).build()
}
