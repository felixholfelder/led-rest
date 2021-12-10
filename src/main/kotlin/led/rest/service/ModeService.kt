package led.rest.service

import led.rest.enums.ColorModeEnum
import org.springframework.stereotype.Service

@Service
class ModeService {
    var test = ColorModeEnum.values()
    fun findAllModes(): MutableList<Int> {
        val list: MutableList<Int> = ArrayList()
        for (t in test) {
            list.add(t.colorModeId)
        }
        return list
    }
}