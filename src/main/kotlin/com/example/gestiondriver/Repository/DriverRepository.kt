package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Co_Driver
import com.example.gestiondriver.Model.Driver
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface DriverRepository : JpaRepository<Driver,Int> {
    fun getByCode(code : String) : Driver
    fun getByDtype(dtype:String) : List<Driver>

}