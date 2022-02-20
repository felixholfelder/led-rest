package led.rest.repository

import led.rest.entity.Module
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ModuleRepository: JpaRepository<Module, Int> {
//    fun findByMac(mac: String): Module
}