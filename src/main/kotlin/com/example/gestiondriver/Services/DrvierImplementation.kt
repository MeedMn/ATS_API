package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Driver
import com.example.gestiondriver.Repository.DriverRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DrvierImplementation (@Autowired val driverRepository: DriverRepository) : DriverInterface {


    override fun CreateDriver(driver: Driver): Driver {
        return driverRepository.save(driver);
    }

    override fun UpdateDriver(id: Int, driver: Driver): Driver {
        return driverRepository.getById(id).let {
            it.nom = driver.nom;
            it.prenom = driver.prenom;
            it.address = driver.address;
            it.age = driver.age;
            it.tele = driver.tele;
            it.permis = driver.permis;
            return driverRepository.save(it);
        }
    }

    override fun ReadSingleDriver(id: Int): Driver {
        return driverRepository.findById(id).get();
    }

    override fun SelectDrivers(): List<Driver> {
        return driverRepository.findAll();
    }

    override fun DeleteDriver(id: Int): String {
       try {
            driverRepository.deleteById(id);
            return "Driver Deleted";
       }catch (error : Exception){
            return "Error in deleting";
       }
    }
}