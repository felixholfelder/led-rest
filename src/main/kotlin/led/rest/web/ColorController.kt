package led.rest.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import led.rest.entity.Color
import led.rest.service.ColorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/colors")
@CrossOrigin("*")
@Tag(name = "Color Controller")
class ColorController(private val colorService: ColorService) {

    @GetMapping
    @Operation(summary = "Returns a list with all colors")
    fun findAllColors(): MutableList<Color> = colorService.findAll()

    @PostMapping
    @Operation(summary = "Creates a new color")
    fun createColor(@RequestBody color: Color): Color = colorService.createColor(color)

    @DeleteMapping("/{colorId}")
    @Operation(summary = "Deletes a color")
    fun deleteColor(@PathVariable colorId: Int) = colorService.deleteColor(colorId)
}