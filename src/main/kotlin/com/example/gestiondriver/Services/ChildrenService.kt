package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Children
import com.example.gestiondriver.Repository.ChildrenRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChildrenService (@Autowired var childrenRepository: ChildrenRepository) : ChildrenInterfaceService {
    override fun createChildren(children: Children): Children {
        return childrenRepository.save(children)
    }

    override fun updateChildren(id: Int, children: Children): Children {
        return childrenRepository.findById(id).get().let{
            it.nom = children.nom
            it.prenom=children.prenom
            it.niveau_scholaire=children.niveau_scholaire
            it.age=  children.age
            return childrenRepository.save(it)
        }
    }

    override fun deleteChildren(id: Int): String {
        try {
            childrenRepository.deleteById(id);
            return "Children deleted"
        }catch (error : Exception){
            return "Children not found"
        }
    }

    override fun selectChildren(): List<Children> {
        return childrenRepository.findAll()
    }
}