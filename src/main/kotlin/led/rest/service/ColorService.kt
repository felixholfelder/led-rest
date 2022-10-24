package led.rest.service

import led.rest.enums.ColorEnum
import led.rest.model.ColorModel
import led.rest.wrapper.ListWrapper
import org.springframework.stereotype.Service

@Service
class ColorService {
  fun findAll(): ListWrapper<ColorModel> {
    val colors = ColorEnum.values()
    val wrapper: ListWrapper<ColorModel> = ListWrapper(listOf())
    val list: MutableList<ColorModel> = mutableListOf()
    for (color in colors) {
      list.add(ColorModel(color.hex))
    }
    wrapper.content = list
    return wrapper
  }
}