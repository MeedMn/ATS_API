package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Driver
import com.example.gestiondriver.Repository.DriverRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DrvierService (@Autowired val driverRepository: DriverRepository) : DriverInterface {


    override fun CreateDriver(driver: Driver): Driver {
        return driverRepository.save(driver);
    }

    override fun UpdateDriver(id: Int, driver: Driver): Driver {
        return driverRepository.findById(id).get().let {
            it.lastname = driver.lastname;
            it.firstname = driver.firstname;
            it.address = driver.address;
            it.age = driver.age;
            it.code = driver.code
            it.numberphone = driver.numberphone;
            it.licence = driver.licence;
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