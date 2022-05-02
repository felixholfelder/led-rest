package led.rest.entity

import javax.persistence.*

@Entity(name = "Color")
@Table(name = "COLOR")
data class Color (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "COLORID")
        var id: Int = 0,

        @Column(name = "HEX")
        val hex: String? = null
)
