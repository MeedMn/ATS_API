package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Children

interface ChildrenInterfaceService {
    fun createChildren(children: Children) : Children
    fun updateChildren(id:Int,children: Children) : Children
    fun deleteChildren(id:Int):String
    fun selectChildren():List<Children>
}