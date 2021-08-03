package led.rest.entity

import javax.persistence.*

@Entity(name = "Mode")
@Table(name = "COLORMODE")
data class Mode(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "COLORMODEID")
        var id: Int = 0,

        @Column(name = "NAME")
        val name: String? = null,

        @Column(name = "KZ")
        val kz: Int? = null
) {
}
