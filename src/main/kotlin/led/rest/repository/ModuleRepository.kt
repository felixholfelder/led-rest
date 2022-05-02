package led.rest.repository

import led.rest.entity.Module
import led.rest.enums.EspStatusEnum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ModuleRepository: JpaRepository<Module, Int> {
    fun findAllByStatus(status: EspStatusEnum): List<Module>
}