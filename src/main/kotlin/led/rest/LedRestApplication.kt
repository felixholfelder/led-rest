package led.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
class SpringBootKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinApplication>(*args)
}