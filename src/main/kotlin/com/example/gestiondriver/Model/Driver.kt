package com.example.gestiondriver.Model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
@Inheritance
@Entity
@Table(name="driver")
open class Driver  (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id:Int,
    open var lastname:String,
    open var firstname:String,
    open var address:String,
    open var age:Int,
    @Column(unique = true)
    open var code:String,
    open var numberphone:String,
    open var licence:String
)