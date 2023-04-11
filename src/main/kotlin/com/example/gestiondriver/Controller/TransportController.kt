package com.example.gestiondriver.Controller
import com.example.gestiondriver.Model.Transport
import com.example.gestiondriver.Services.Co_DriverService
import com.example.gestiondriver.Services.DrvierService
import com.example.gestiondriver.Services.TransportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
@CrossOrigin
class TransportController (@Autowired var transportService: TransportService,@Autowired var codriverService: Co_DriverService,@Autowired var driverService: DrvierService) {
    @PostMapping("createTransport/{codeDriver}/{codeCoDriver}")
    fun CreateTransport (@PathVariable codeDriver:String,@PathVariable codeCoDriver:String,@RequestBody transport: Transport) : Transport{
        println("added")
        transport.let {
            it.id_CoDriver = codriverService.getCoDriverByCode(codeCoDriver)
            it.id_driver = driverService.getDriverByCode(codeDriver)
            return transport
        }
    }
    @GetMapping("transports")
    fun SelectTransport() : List<Transport> {
        return transportService.ReadAll()
    }
    @PutMapping("updateTransport")
    fun UpdateTransport(@PathVariable id: Int,@RequestBody transport: Transport) : Transport{
        return transportService.UpdateTransport(id,transport)
    }
    @DeleteMapping("deleteTransport")
    fun DeleteTransport (@RequestBody id : Int) : String {
        return transportService.DeleteTransport(id)
    }
    @GetMapping("transport/{id}")
    fun SelectById(@PathVariable id : Int) : Transport {
        return transportService.ReadSingle(id)
    }
}