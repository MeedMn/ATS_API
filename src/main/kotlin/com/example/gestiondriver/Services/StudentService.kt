package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Student
import com.example.gestiondriver.Repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService (@Autowired var studentRepository: StudentRepository) : StudentInterfaceService {
    override fun createChildren(student: Student): Student {
        return studentRepository.save(student)
    }

    override fun updateChildren(id: Int, student: Student): Student {
        return studentRepository.findById(id).get().let{
            it.lastname = student.lastname
            it.firstname=student.firstname
            it.grade=student.grade
            it.age=  student.age
            return studentRepository.save(it)
        }
    }

    override fun deleteChildren(id: Int): String {
        try {
            studentRepository.deleteById(id);
            return "Student deleted"
        }catch (error : Exception){
            return "Student not found"
        }
    }

    override fun selectChildren(): List<Student> {
        return studentRepository.findAll()
    }
}