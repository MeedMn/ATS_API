package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User,Int> {
    fun findByEmail(email:String):Optional<User>
}