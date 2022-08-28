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

    @PostMapping
    @Operation(summary = "Creates a new module")
    fun createModule(@RequestBody module: Module) = moduleService.createNewModule(module)

    @PatchMapping("/address")
    @Operation(summary = "Sets the IP of a module")
    fun setStatus(@RequestBody module: StatusModel) = moduleService.setStatus(module)

    @PutMapping("/{moduleId}")
    @Operation(summary = "Updates a module")
    fun updateModule(@PathVariable moduleId: String?, @RequestBody module: Module) =
        moduleService.updateModule(moduleId, module)

    @DeleteMapping("/{moduleId}")
    @Operation(summary = "Deletes a module")
    fun deleteModule(@PathVariable moduleId: String) = moduleService.deleteModule(moduleId)
}