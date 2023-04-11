package com.example.gestiondriver.Controller
import com.example.gestiondriver.Model.Co_Driver
import com.example.gestiondriver.Services.Co_DriverService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import kotlin.contracts.contract
@RestController
@RequestMapping("/")
@CrossOrigin
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