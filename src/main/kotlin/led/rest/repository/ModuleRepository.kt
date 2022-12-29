package led.rest.repository

import led.rest.entity.Module
import org.springframework.data.mongodb.repository.MongoRepository

interface ModuleRepository : MongoRepository<Module, String> {
  fun findAllByOrderByName(): List<Module>
  fun findByMac(mac: String?): Module?
  fun findById(id: String?): Module
}