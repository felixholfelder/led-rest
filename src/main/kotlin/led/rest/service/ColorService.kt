package led.rest.service

import led.rest.entity.Color
import led.rest.repository.ColorRepository
import led.rest.wrapper.ListWrapper
import org.springframework.stereotype.Service

@Service
class ColorService(private val colorRepository: ColorRepository) {
    fun findAll() = ListWrapper(colorRepository.findAll())

    fun createColor(color: Color): Color = colorRepository.save(color)

    fun deleteColor(colorId: Int) = colorRepository.deleteById(colorId)
}