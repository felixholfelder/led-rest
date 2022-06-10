package led.rest.service

import led.rest.enums.ColorModeEnum
import led.rest.model.ModeModel
import org.springframework.stereotype.Service

@Service
class ModeService {
    var modes = ColorModeEnum.values()
    fun findAll(): MutableList<ModeModel> {
        val list: MutableList<ModeModel> = ArrayList()
        for (mode in modes) {
            list.add(ModeModel(mode.modeName, mode.modeId))
        }
        return list
    }
}