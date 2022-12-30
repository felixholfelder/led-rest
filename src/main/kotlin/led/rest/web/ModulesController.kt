package led.rest.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import led.rest.entity.Module
import led.rest.model.StatusModel
import led.rest.service.ModuleService
import led.rest.wrapper.ListWrapper
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/modules")
@CrossOrigin("*")
@Tag(name = "Modules Controller")
class ModulesController(private val moduleService: ModuleService) {
  @GetMapping
  @Operation(summary = "Returns a list with all modules")
  fun findAll(): ListWrapper<Module> = moduleService.findAll()

  @PatchMapping("/address")
  @Operation(summary = "Sets the IP of a module")
  fun setAddress(@RequestBody module: StatusModel) = moduleService.setAddress(module)

  @DeleteMapping("/{id}")
  @Operation(summary = "Deletes a module")
  fun deleteModule(@PathVariable id: String) = moduleService.deleteModule(id)
}