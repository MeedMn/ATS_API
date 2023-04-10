package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Children
import org.springframework.data.jpa.repository.JpaRepository

interface ChildrenRepository : JpaRepository<Children,Int> {
}