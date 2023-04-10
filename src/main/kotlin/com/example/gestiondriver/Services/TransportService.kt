package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Transport
import com.example.gestiondriver.Repository.TransportRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransportService (@Autowired val TransportRepo : TransportRepository): TransportInterface {
    override fun CreateTransport(transport: Transport): Transport {
        return TransportRepo.save(transport)
    }

    override fun UpdateTransport(id: Int, transport: Transport): Transport {
        return TransportRepo.getById(id).let {
            it.registration_number = transport.registration_number
            it.fuel = transport.fuel
            it.seat_number= transport.seat_number
            it.id_driver.id= transport.id_driver.id
            it.id_CoDriver.id = transport.id_CoDriver.id
            return TransportRepo.save(it)
        }
    }

    override fun ReadAll(): List<Transport> {
        return TransportRepo.findAll()
    }

    override fun ReadSingle(id: Int): Transport {
        return TransportRepo.getById(id)
    }

    override fun DeleteTransport(id: Int): String {
        try {
            TransportRepo.deleteById(id)
            return "Transport Sold"
        }catch (error : Exception){
            return "Error " + error.stackTrace
        }
    }
}