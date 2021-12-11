package led.rest.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import led.rest.service.ModeService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/modes")
@CrossOrigin("*")
@Tag(name = "Modes Controller")
class ModesController(private val modeService: ModeService) {

    @GetMapping("")
    @Operation(summary = "Gibt eine Liste mit allen Farbmodi zurück")
    fun getAllColorModes(): MutableList<Int> {
        return modeService.findAllModes()
    }
}