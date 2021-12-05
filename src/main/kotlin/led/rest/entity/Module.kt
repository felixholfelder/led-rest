package led.rest.entity

import led.rest.enums.EspStatusEnum
import java.time.ZonedDateTime
import javax.persistence.*

@Entity(name = "Module")
@Table(name = "LEDMODULE")
data class Module(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "LEDMODULE_ID")
        var id: Int = 0,

        @Column(name = "NAME")
        val name: String? = null,

        @Column(name = "TYPE")
        val type: String? = null,

        @Column(name = "MAC")
        val mac: String? = null,

        @Column(name = "IP")
        var ip: String? = null
) {
}