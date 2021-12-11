package led.rest.service

import led.rest.entity.Module
import led.rest.repository.ModuleRepository
import org.springframework.stereotype.Service

@Service
class ModuleService(private val moduleRepository: ModuleRepository) {
    fun findAllModules(): List<Module> {
        return moduleRepository.findAll()
    }

    fun createNewModule(module: Module): Module {
        return moduleRepository.saveAndFlush(module)
    }

    fun updateModule(moduleId: Int, module: Module): Module {
        val newModule = Module(moduleId, module.name, module.mac, module.address)
        return moduleRepository.saveAndFlush(newModule)
    }

    fun deleteModule(moduleId: Int) {
        moduleRepository.deleteById(moduleId)
    }
}