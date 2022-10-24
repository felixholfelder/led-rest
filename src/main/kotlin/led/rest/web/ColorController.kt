package led.rest.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import led.rest.model.ColorModel
import led.rest.service.ColorService
import led.rest.wrapper.ListWrapper
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/colors")
@CrossOrigin("*")
@Tag(name = "Color Controller")
class ColorController(private val colorService: ColorService) {

  @GetMapping
  @Operation(summary = "Returns a list with all colors")
  fun findAllColors(): ListWrapper<ColorModel> = colorService.findAll()
}