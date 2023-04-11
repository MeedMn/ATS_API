package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Co_Driver
import com.example.gestiondriver.Repository.Co_DriverRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Co_DriverService (@Autowired val coDriverService : Co_DriverRepository ) : Co_DriverInterface {
    override fun CreateCoDriver(coDriver: Co_Driver): Co_Driver {
        return coDriverService.save(coDriver)
    }

    override fun UpdateCoDriver(id: Int, coDriver: Co_Driver): Co_Driver {
        return coDriverService.getById(id).let {
            it.lastname = coDriver.lastname
            it.firstname = coDriver.firstname
            it.address = coDriver.address
            it.age = coDriver.age
            it.code = coDriver.code
            it.numberphone = coDriver.numberphone
            it.licence = coDriver.licence
            return coDriverService.save(it)
        }
    }

    override fun ReadAll(): List<Co_Driver> {
        return coDriverService.findAll()
    }

    override fun ReadSingle(id: Int): Co_Driver {
        return coDriverService.getById(id)
    }

    override fun DeleteCoDriver(id: Int): String {
        try {
            coDriverService.deleteById(id)
            return "CoDriver Deleted"
        }catch (error : Exception){
            return "Error of Deleting"
        }
    }

    override fun getCoDriverByCode(code: String): Co_Driver {
        println("Co-Driver : "+coDriverService.getByCode(code).firstname)
        return coDriverService.getByCode(code)
    }
}