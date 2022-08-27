package led.rest.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Color (
        @Id
        @Indexed(name = "COLORID")
        var id: Int = 0,

        @Indexed
        val hex: String? = null
)
