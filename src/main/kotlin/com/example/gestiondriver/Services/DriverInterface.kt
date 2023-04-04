package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Driver

interface DriverInterface {
    fun CreateDriver(driver: Driver): Driver;
    fun UpdateDriver(id : Int, driver:Driver):Driver;
    fun ReadSingleDriver(id:Int) : Driver;
    fun SelectDrivers () : List<Driver>;
    fun DeleteDriver(id:Int) : String;
}