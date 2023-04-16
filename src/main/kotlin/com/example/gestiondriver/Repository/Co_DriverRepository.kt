package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Co_Driver
import com.example.gestiondriver.Model.Driver
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Co_DriverRepository : JpaRepository<Co_Driver,Int> {
    fun getByCode(code : String) : Co_Driver
    fun getByDtype (dtype:String) : List<Co_Driver>
}