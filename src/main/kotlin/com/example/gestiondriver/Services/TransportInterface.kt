package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Transport
import org.springframework.data.jpa.repository.JpaRepository

interface TransportInterface{
    fun CreateTransport(transport: Transport) : Transport
    fun UpdateTransport(id : Int , transport: Transport) : Transport
    fun ReadAll() : List<Transport>
    fun ReadSingle(id : Int) : Transport
    fun DeleteTransport(id : Int) : String
    fun affectDriverCodriverToTransport(idTransport: Int,idDriver : Int,idCodriver:Int)
}