package led.rest.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import led.rest.entity.Module
import led.rest.enums.EspStatusEnum
import led.rest.service.ModuleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/modules")
@CrossOrigin("*")
@Tag(name = "Modules Controller")
class ModulesController(private val moduleService: ModuleService) {
    @GetMapping
    @Operation(summary = "Returns a list of modules based on the status")
    fun findAllModules(@RequestParam status: EspStatusEnum): List<Module> {
        return moduleService.findAllByStatus(status)
    }

    @PostMapping
    @Operation(summary = "Creates a new module")
    fun createModule(@RequestBody module: Module): Module {
        return moduleService.createNewModule(module)
    }

    @PutMapping("/{moduleId}")
    @Operation(summary = "Updates a module")
    fun updateModule(@PathVariable("moduleId") moduleId: Int, @RequestBody module: Module): Module {
        return moduleService.updateModule(moduleId, module)
    }
    
    @DeleteMapping
    @Operation(summary = "Deletes a module")
    fun deleteModule(@PathVariable("moduleId") moduleId: Int) {
        moduleService.deleteModule(moduleId)
    }
}