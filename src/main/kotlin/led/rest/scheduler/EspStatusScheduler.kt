package led.rest.scheduler

import led.rest.entity.Module
import led.rest.enums.EspStatusEnum
import led.rest.repository.ModuleRepository
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class EspStatusScheduler(private val moduleRepository: ModuleRepository) {
    private val FIFTEEN: Long = 15
    private val log = LoggerFactory.getLogger(javaClass)

//    @Scheduled(fixedDelay = 15000)
//    private fun checkCurrentLedModules() {
//        log.info("Suche nach aktiven Modulen...")
//        val modules: List<Module> = moduleRepository.findAllByStatus(EspStatusEnum.ACTIVE)
//        val now: ZonedDateTime = ZonedDateTime.now()
//        val fifteenSecondsAgo: ZonedDateTime = now.minusSeconds(FIFTEEN)
//        modules.forEach {
//            log.info("Prüfe, ob der letzte Sync ist älter als $FIFTEEN Sekunden...")
//            if (it.syncDate?.toInstant()?.isBefore(fifteenSecondsAgo.toInstant()) == true) {
//                it.status = EspStatusEnum.INACTIVE
//                it.syncDate = ZonedDateTime.now()
//                moduleRepository.saveAndFlush(it)
//                log.info("Module ${it.name} ist jetzt inaktiv!")
//            }
//        }
//        log.info("Prüfung abgeschlossen!")
//    }
}