package led.rest.service

import led.rest.entity.Module
import led.rest.model.StatusModel
import led.rest.repository.ModuleRepository
import led.rest.wrapper.ListWrapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ModuleService(private val moduleRepository: ModuleRepository) {

  val log: Logger = LoggerFactory.getLogger(ModuleService::class.java)

  fun findAll() = ListWrapper(moduleRepository.findAllByOrderByName())

  /**
   * If no module was found create a new one
   * */
  fun setAddress(newModule: StatusModel) {
    log.info("Register new module with name ${newModule.name}...")
    var module = moduleRepository.findByMac(newModule.mac.uppercase())
    if (module == null) {
      module = Module(null, newModule.name, newModule.address, newModule.mac)
    } else {
      module.address = newModule.address
      module.name = newModule.name
    }
    moduleRepository.save(module)
    log.info("Module ${module.name} registered!")
  }

  fun updateModule(moduleId: String?, newModule: Module): Module {
    val module: Module = moduleRepository.findById(moduleId)
    module.name = newModule.name
    module.address = newModule.address
    module.mac = newModule.mac
    moduleRepository.save(module)
    return module
  }

  fun deleteModule(moduleId: String) = moduleRepository.deleteById(moduleId)
}