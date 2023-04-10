package com.example.gestiondriver.Controller

import com.example.gestiondriver.Model.Children
import com.example.gestiondriver.Services.ChildrenService
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
class ChildrenController (@Autowired var childrenService: ChildrenService){
    @PostMapping("createChildren")
    fun createChildren(@RequestBody children: Children) : Children{
        return childrenService.createChildren(children)
    }
    @GetMapping("childrens")
    fun selectChildren():List<Children>{
        return childrenService.selectChildren()
    }
    @PutMapping("updateChildren/{id}")
    fun updateChildren (@PathVariable id:Int,@RequestBody children: Children) : Children {
        return childrenService.updateChildren(id,children)
    }
    @DeleteMapping("deleteChildren/{id}")
    fun deleteChildren (@PathVariable id:Int) : String {
        return childrenService.deleteChildren(id)
    }
}