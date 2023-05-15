package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Parent
import java.util.function.Predicate

interface ParentInterfaceService {
    fun createParent(parent: Parent):Parent;
    fun updateParent(id:Int,parent: Parent):Parent
    fun deleteParent(id: Int):String
    fun selectParent() : List<Parent>
    fun affectChildToParent(idParent : Int , idChild : Int);
    fun getById(idParent :  Int) : Parent;
}