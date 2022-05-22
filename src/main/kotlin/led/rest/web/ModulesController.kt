package led.rest.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import led.rest.entity.Module
import led.rest.service.ModuleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/modules")
@CrossOrigin("*")
@Tag(name = "Modules Controller")
class ModulesController(private val moduleService: ModuleService) {
    @GetMapping
    @Operation(summary = "Returns a list with all modules")
    fun findAll(): List<Module> {
        return moduleService.findAll()
    }

    @PostMapping
    @Operation(summary = "Creates a new module")
    fun createModule(@RequestBody module: Module): Module {
        return moduleService.createNewModule(module)
    }

    @PutMapping("/{moduleId}")
    @Operation(summary = "Updates a module")
    fun updateModule(@PathVariable moduleId: Int, @RequestBody module: Module): Module {
        return moduleService.updateModule(moduleId, module)
    }

    @DeleteMapping("/{moduleId}")
    @Operation(summary = "Deletes a module")
    fun deleteModule(@PathVariable moduleId: Int) {
        moduleService.deleteModule(moduleId)
    }
}