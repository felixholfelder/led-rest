package led.rest.service

import led.rest.entity.Module
import led.rest.model.StatusModel
import led.rest.repository.ModuleRepository
import led.rest.wrapper.ListWrapper
import org.springframework.stereotype.Service
import java.util.*

@Service
class ModuleService(private val moduleRepository: ModuleRepository) {
    fun findAll() = ListWrapper(moduleRepository.findAllByOrderByName())

    fun createNewModule(module: Module) = ListWrapper(listOf(moduleRepository.saveAndFlush(module)))

    fun setStatus(newModule: StatusModel) {
        val module = moduleRepository.findByMac(newModule.mac?.uppercase())
        module.address = newModule.address
        moduleRepository.saveAndFlush(module)
    }

    fun updateModule(moduleId: Int?, newModule: Module): ListWrapper<Module> {
        val module: Module = moduleRepository.findById(moduleId)
        module.name = newModule.name
        module.address = newModule.address
        module.mac = newModule.mac
        moduleRepository.saveAndFlush(module)
        return ListWrapper(listOf(module))
    }

    fun deleteModule(moduleId: Int) = moduleRepository.deleteById(moduleId)
}