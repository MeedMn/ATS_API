package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Driver
import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository : JpaRepository<Driver,Int> {
}