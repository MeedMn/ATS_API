package com.example.gestiondriver.Model

import jakarta.persistence.*

@Entity
class Co_Driver
    (
    override var id:Int,
    override var lastname:String,
    override var firstname:String,
    override var address:String,
    override var age:Int,
    @Column(unique = true)
    override var code:String,
    override var numberphone:String,
    override var licence:String
            ): Driver(id,lastname,firstname, address,age, code , numberphone, licence)