package led.rest.repository

import led.rest.entity.Color
import org.springframework.data.mongodb.repository.MongoRepository

interface ColorRepository : MongoRepository<Color, Int>