package led.rest.service

import led.rest.entity.Color
import led.rest.repository.ColorRepository
import org.springframework.stereotype.Service

@Service
class ColorService(private val colorRepository: ColorRepository) {
    fun findAll(): MutableList<Color> = colorRepository.findAll()

    fun createColor(color: Color): Color = colorRepository.save(color)

    fun deleteColor(colorId: Int) = colorRepository.deleteById(colorId)
}