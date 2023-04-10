package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Student

interface StudentInterfaceService {
    fun createChildren(student: Student) : Student
    fun updateChildren(id:Int, student: Student) : Student
    fun deleteChildren(id:Int):String
    fun selectChildren():List<Student>
}