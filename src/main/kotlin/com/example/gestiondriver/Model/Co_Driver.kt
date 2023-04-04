package com.example.gestiondriver.Model

import jakarta.persistence.*

@Entity
class Co_Driver
    (
    override var id:Int,
    override var nom:String,
    override var prenom:String,
    override var address:String,
    override var age:Int,
    override var tele:String,
    override var permis:String
            ): Driver(id,nom,prenom,address,age ,tele,permis)