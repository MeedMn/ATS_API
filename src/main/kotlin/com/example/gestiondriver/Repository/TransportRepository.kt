package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Transport
import org.springframework.data.jpa.repository.JpaRepository

interface TransportRepository : JpaRepository<Transport,Int>{
}