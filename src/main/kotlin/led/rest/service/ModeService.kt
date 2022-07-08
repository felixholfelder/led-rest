package led.rest.service

import led.rest.enums.ColorModeEnum
import led.rest.model.ModeModel
import led.rest.wrapper.ListWrapper
import org.springframework.stereotype.Service

@Service
class ModeService {
    fun findAll(): ListWrapper<ModeModel> {
        var modes = ColorModeEnum.values()
        val wrapper: ListWrapper<ModeModel> = ListWrapper(listOf())
        val list: MutableList<ModeModel> = mutableListOf()
        for (mode in modes) {
            list.add(ModeModel(mode.modeName, mode.modeId))
        }
        wrapper.content = list
        return wrapper
    }
}