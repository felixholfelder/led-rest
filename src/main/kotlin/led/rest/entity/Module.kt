package led.rest.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "module")
data class Module(
        @Id
        var id: Int = 0,

        @Indexed
        var name: String? = null,

        @Indexed
        var address: String? = null,

        @Indexed(unique = true)
        var mac: String? = null
)
