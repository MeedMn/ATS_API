package com.example.gestiondriver.Controller

import com.example.gestiondriver.Model.Parent
import com.example.gestiondriver.Services.ParentService
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
class ParentController (@Autowired var parentService: ParentService) {

    @PostMapping("createParent")
    fun createParent(@RequestBody parent: Parent) : Parent {
        return parentService.createParent(parent)
    }

    @GetMapping("parents")
    fun selectParents () : List<Parent> {
        return parentService.selectParent();
    }

    @PutMapping("updateParent/{id}")
    fun updateParent (@PathVariable id:Int, @RequestBody parent: Parent) : Parent {
        return parentService.updateParent(id,parent);
    }

    @DeleteMapping("deletePatient/{id}")
    fun deletePatient (@PathVariable id:Int) : String {
        return parentService.deleteParent(id);
    }

    @PostMapping("affectChildToParent/{idc}/{idp}")
    fun affectChildToParent(@PathVariable idc:Int,@PathVariable idp:Int) : String{
        try {
            parentService.affectChildToParent(idc,idp)
            return "Relation setted"
        }catch (e:Exception){
            return "Relation not setted | Error : "+e.stackTrace
        }
    }
}