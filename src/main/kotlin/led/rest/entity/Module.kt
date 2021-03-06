package led.rest.entity

import javax.persistence.*

@Entity(name = "Module")
@Table(name = "LEDMODULE")
data class Module(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "LEDMODULE_ID")
        var id: Int = 0,

        @Column(name = "NAME")
        var name: String? = null,

        @Column(name = "ADDRESS")
        var address: String? = null,

        @Column(name = "MAC")
        var mac: String? = null
)
