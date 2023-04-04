package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Co_Driver
import org.springframework.data.jpa.repository.JpaRepository

interface Co_DriverRepository : JpaRepository<Co_Driver,Int> {
}