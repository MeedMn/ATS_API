package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Co_Driver

interface Co_DriverInterface {
    fun CreateCoDriver(coDriver : Co_Driver):Co_Driver
    fun UpdateCoDriver(id : Int , coDriver : Co_Driver) : Co_Driver
    fun ReadAll():List<Co_Driver>
    fun ReadSingle(id : Int):Co_Driver
    fun DeleteCoDriver(id: Int) : String
}