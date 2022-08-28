package led.rest.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "module")
data class Module(
        @Id
        var id: String?,

        @Indexed
        var name: String,

        @Indexed
        var address: String,

        @Indexed(unique = true)
        var mac: String?
)
