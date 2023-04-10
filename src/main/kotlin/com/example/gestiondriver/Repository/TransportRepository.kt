package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Transport
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransportRepository : JpaRepository<Transport,Int>{
}