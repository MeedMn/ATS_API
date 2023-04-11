package com.example.gestiondriver.Controller

import com.example.gestiondriver.Model.Driver
import com.example.gestiondriver.Services.DriverInterface
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
@CrossOrigin
class DriverController (@Autowired val driverService: DriverInterface){
    @PostMapping("createDriver")
    public fun CreateDriver(@RequestBody driver:Driver) : Driver{
        return driverService.CreateDriver(driver);
    }
    @GetMapping("drivers")
    public fun ReadAll() : List<Driver>{
        return driverService.SelectDrivers();
    }
    @PutMapping("updateDriver/{id}")
    public fun UpdateDriver(@PathVariable id:Int,@RequestBody driver:Driver):Driver{
        return driverService.UpdateDriver(id,driver);
    }
    @DeleteMapping("deleteDriver/{id}")
    public fun DeleteDriver(@PathVariable id:Int) : String{
        return driverService.DeleteDriver(id);
    }
    @GetMapping("driver/id/{id}")
    public fun ReadSingle(@PathVariable id:Int) : Driver{
        return driverService.ReadSingleDriver(id);
    }
    @GetMapping("driver/code/{code}")
    public fun getDriverByCode(@PathVariable code: String): Driver {
        return driverService.getDriverByCode(code)
    }
}