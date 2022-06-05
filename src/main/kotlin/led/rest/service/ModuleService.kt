package led.rest.service

import led.rest.entity.Module
import led.rest.model.StatusModel
import led.rest.repository.ModuleRepository
import org.springframework.stereotype.Service

@Service
class ModuleService(private val moduleRepository: ModuleRepository) {
    fun findAll(): List<Module> = moduleRepository.findAllByOrderByName()

    fun createNewModule(module: Module): Module = moduleRepository.saveAndFlush(module)

    fun setStatus(newModule: StatusModel) {
        val module = moduleRepository.findByMac(newModule.mac?.uppercase())
        module.address = newModule.address
        moduleRepository.saveAndFlush(module)
    }

    fun deleteModule(moduleId: Int) = moduleRepository.deleteById(moduleId)
}