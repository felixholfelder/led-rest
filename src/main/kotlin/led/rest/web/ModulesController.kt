package led.rest.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import led.rest.entity.Module
import led.rest.model.EspStatusModel
import led.rest.service.ModuleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/modules")
@CrossOrigin("*")
@Tag(name = "Modules Controller")
class ModulesController(private val moduleService: ModuleService) {

    @GetMapping("")
    @Operation(summary = "Gibt eine List mit Modulen zurück anhand des übergebenen Status zurück")
    fun getAllModules(): List<Module> {
        return moduleService.findAllModules()
    }

    @PostMapping("")
    @Operation(summary = "Erstellt ein neues Modul")
    fun createModule(@RequestBody module: Module): Module {
        return moduleService.createNewModule(module)
    }

    @PostMapping("/status")
    @Operation(summary = "Aktualisiert den Status von einem Modul")
    fun setEspStatus(@RequestBody statusModel: EspStatusModel): String {
        return moduleService.setStatus(statusModel.ip, statusModel.mac)
    }

    @PutMapping("/{moduleId}")
    @Operation(summary = "Aktualisiert das übergebene Modul")
    fun updateModule(@PathVariable("moduleId") moduleId: Int, @RequestBody module: Module): Module {
        return moduleService.updateModule(moduleId, module)
    }

    fun deleteModule(@PathVariable("moduleId") moduleId: Int) {
        moduleService.deleteModule(moduleId)
    }
}