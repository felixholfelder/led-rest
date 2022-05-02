package led.rest.repository

import led.rest.entity.Color
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ColorRepository : JpaRepository<Color, Int>