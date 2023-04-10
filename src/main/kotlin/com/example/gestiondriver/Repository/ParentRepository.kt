package com.example.gestiondriver.Repository

import com.example.gestiondriver.Model.Student
import com.example.gestiondriver.Model.Parent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ParentRepository : JpaRepository<Parent,Int>  {
    @Query(value = "select pr from Parent pr where pr.id=:id")
    fun getChilds (@Param ("id") id:Int) : List<Student>
}