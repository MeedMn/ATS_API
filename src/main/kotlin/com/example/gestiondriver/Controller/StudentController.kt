package com.example.gestiondriver.Controller

import com.example.gestiondriver.Model.Student
import com.example.gestiondriver.Services.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
@CrossOrigin
class StudentController (@Autowired var childrenService: StudentService){
    @PostMapping("createChildren")
    fun createChildren(@RequestBody student: Student) : Student{
        return childrenService.createChildren(student)
    }
    @GetMapping("childrens")
    fun selectChildren():List<Student>{
        return childrenService.selectChildren()
    }
    @PutMapping("updateChildren/{id}")
    fun updateChildren (@PathVariable id:Int,@RequestBody student: Student) : Student {
        return childrenService.updateChildren(id,student)
    }
    @DeleteMapping("deleteChildren/{id}")
    fun deleteChildren (@PathVariable id:Int) : String {
        return childrenService.deleteChildren(id)
    }
}