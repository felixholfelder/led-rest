package led.rest.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import led.rest.model.ModeModel
import led.rest.service.ModeService
import led.rest.wrapper.ListWrapper
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/modes")
@CrossOrigin("*")
@Tag(name = "Modes Controller")
class ModesController(private val modeService: ModeService) {
  @GetMapping
  @Operation(summary = "Returns a list with all colormodes")
  fun findAllColorModes(): ListWrapper<ModeModel> = modeService.findAll()
}