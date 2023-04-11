package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Student
import com.example.gestiondriver.Model.Parent
import com.example.gestiondriver.Repository.StudentRepository
import com.example.gestiondriver.Repository.ParentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ParentService (@Autowired var parentRepository: ParentRepository,@Autowired var studentRepository: StudentRepository) : ParentInterfaceService {

    override fun createParent(parent: Parent): Parent {
        return parentRepository.save(parent)
    }

    override fun updateParent(id: Int, parent: Parent): Parent {
        return parentRepository.findById(id).get().let {
            it.lastname = parent.lastname;
            it.firstname = parent.firstname;
            it.numberphone = parent.numberphone;
            it.address = parent.address
            it.student= parent.student
            return parentRepository.save(it);
        }
    }

    override fun deleteParent(id: Int): String {
        try {
            parentRepository.deleteById(id)
            return "Parent deleted"
        }catch ( e : Exception){
            return "Parent not found"
        }
    }

    override fun selectParent(): List<Parent> {
        return parentRepository.findAll()
    }

    override fun affectChildToParent(idChild: Int, idParent: Int) {
        var parent:Parent = parentRepository.findById(idParent).get();
        var std: Student = studentRepository.findById(idChild).get();

        if(parent != null && std != null){

            parent.student += std
            parentRepository.save(parent);
        }
    }


}