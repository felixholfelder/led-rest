package led.rest.service

import led.rest.enums.ColorModeEnum
import org.springframework.stereotype.Service

@Service
class ModeService {
    fun findAllModes(): Array<ColorModeEnum> {
        return ColorModeEnum.values()
    }
}