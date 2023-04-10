package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Children
import com.example.gestiondriver.Model.Parent
import com.example.gestiondriver.Repository.ChildrenRepository
import com.example.gestiondriver.Repository.ParentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.CrossOrigin

@Service
class ParentService (@Autowired var parentRepository: ParentRepository) : ParentInterfaceService {
    @Autowired
    lateinit var  childrenRepository : ChildrenRepository ;


    override fun createParent(parent: Parent): Parent {
        return parentRepository.save(parent)
    }

    override fun updateParent(id: Int, parent: Parent): Parent {
        return parentRepository.findById(id).get().let {
            it.nom = parent.nom;
            it.prenom = parent.prenom;
            it.numero = parent.numero;
            it.address = parent.address
            it.children= parent.children
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

    override fun affectChildToParent(idParent: Int, idChild: Int) {
        var parent:Parent = parentRepository.findById(idParent).get();
        var child: Children = childrenRepository.findById(idChild).get();
        if(parent != null && child != null){
            parent.children.toMutableList().add(child)
            parentRepository.save(parent);
        }
    }


}