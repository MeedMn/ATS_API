package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student,Int> {
}