package led.rest.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override
    fun configure(web: WebSecurity?) {
        web?.ignoring()?.antMatchers(HttpMethod.OPTIONS, "/**")
    }

    override
    fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()
            ?.sessionManagement()
            ?.sessionCreationPolicy(SessionCreationPolicy.NEVER)
            ?.and()
            ?.authorizeRequests()
            ?.antMatchers("/api/modules/address")?.permitAll()
            ?.and()
            ?.authorizeRequests()?.anyRequest()?.authenticated()
            ?.and()?.httpBasic()
    }
}