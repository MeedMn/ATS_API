package com.example.gestiondriver.Controller
import com.example.gestiondriver.Model.Transport
import com.example.gestiondriver.Services.Co_DriverService
import com.example.gestiondriver.Services.DriverService
import com.example.gestiondriver.Services.TransportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
@CrossOrigin
class TransportController (@Autowired var transportService: TransportService,@Autowired var codriverService: Co_DriverService,@Autowired var driverService: DriverService) {
    @PostMapping("createTransport")
    fun CreateTransport(@RequestBody transport: Transport) : Transport{
        println(transport.registration_number)
        return transportService.CreateTransport(transport)
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

    @PostMapping("affectDrvierCoDriver/{idTransport}/{idDriver}/{idCoDriver}")
    fun affectDriverCoDriverToTransport(@PathVariable idTransport:Int,@PathVariable idDriver:Int,@PathVariable idCoDriver : Int):String{
        try{
            transportService.affectDriverCodriverToTransport(idTransport,idDriver,idCoDriver)
            return "Driver and Co Driver are affected"
        }catch (Error : Exception){
            return "Error in traitement | Error : " + Error.cause
        }

    }
}