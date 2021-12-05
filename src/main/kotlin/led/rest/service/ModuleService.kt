package led.rest.service

import led.rest.entity.Module
import led.rest.enums.EspStatusEnum
import led.rest.repository.ModuleRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.ResourceAccessException

@Service
class ModuleService(private val moduleRepository: ModuleRepository) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun findAllModules(statusEnum: EspStatusEnum?): List<Module> {
        if(statusEnum == null) {
            return moduleRepository.findAll()
        }
        return moduleRepository.findAllByStatus(statusEnum)
    }

    fun setStatus(ip: String, mac: String): String {
        var module = Module()
        try {
            log.info("Suche nach MAC $mac")
            module = moduleRepository.findByMac(mac)
            module.status = EspStatusEnum.ACTIVE
            module.ip = ip
            moduleRepository.saveAndFlush(module)
            log.info("Status von ESP ${module.name} wurde aktualisiert!")
        } catch (e: Exception) {
            throw ResourceAccessException("Der Status für den ESP ${module.name} konnte nicht gesetzt werden!")
        }
        return module.toString()
    }

    fun createNewModule(module: Module): Module {
        return moduleRepository.saveAndFlush(module)
    }

    fun updateModule(moduleId: Int, module: Module): Module {
        val newModule = Module(moduleId, module.name, module.type, module.icon, module.mac, module.status, module.syncDate)
        return moduleRepository.saveAndFlush(newModule)
    }

    fun deleteModule(moduleId: Int) {
        moduleRepository.deleteById(moduleId)
    }
}