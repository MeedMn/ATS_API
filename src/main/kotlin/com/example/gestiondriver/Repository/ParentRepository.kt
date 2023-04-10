package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Children
import com.example.gestiondriver.Model.Parent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ParentRepository : JpaRepository<Parent,Int>  {
    @Query(value = "select pr from Parent pr where pr.id=:id")
    fun getChilds (@Param ("id") id:Int) : List<Children>
}