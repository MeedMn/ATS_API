package com.example.gestiondriver.Controller
import com.example.gestiondriver.Model.Transport
import com.example.gestiondriver.Services.TransportService
import org.springframework.beans.factory.annotation.Autowired
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
class TransportController (@Autowired var transportService: TransportService) {
    @PostMapping("createTransport")
    fun CreateTransport (@RequestBody transport: Transport) : Transport{
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
}