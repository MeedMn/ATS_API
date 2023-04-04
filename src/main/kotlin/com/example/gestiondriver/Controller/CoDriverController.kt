package com.example.gestiondriver.Controller
import com.example.gestiondriver.Model.Co_Driver
import com.example.gestiondriver.Services.Co_DriverService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.contracts.contract
@RestController
@RequestMapping("/")
class CoDriverController (@Autowired var coDriverservice: Co_DriverService) {
    @PostMapping("createCoDriver")
    fun CreateCoDriver (@RequestBody  coDriver : Co_Driver) : Co_Driver{
        return coDriverservice.CreateCoDriver(coDriver)
    }
    @GetMapping("coDrivers")
    fun SelectCoDrivers () : List<Co_Driver>{
        return coDriverservice.ReadAll()
    }
    @PutMapping("updateCoDriver/{id}")
    fun UpdateCoDriver(@PathVariable id : Int,@RequestBody coDriver: Co_Driver) : Co_Driver
    {
        return coDriverservice.UpdateCoDriver(id,coDriver)
    }
    @DeleteMapping("deleteCoDriver/{id}")
    fun DeleteCoDriver(@PathVariable id : Int) : String{
        return coDriverservice.DeleteCoDriver(id)
    }
    @GetMapping("coDriver/{id}")
    fun SelectById(@PathVariable id : Int) : Co_Driver {
        return coDriverservice.ReadSingle(id)
    }
}