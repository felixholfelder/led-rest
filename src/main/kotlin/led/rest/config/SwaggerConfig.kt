package led.rest.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
                .components(Components())
                .info(Info()
                        .title("Led-Rest")
                        .description("Swagger-Doc for Led-Rest test"))
    }
}