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
    open var nom:String,
    open var prenom:String,
    open var address:String,
    open var age:Int,
    open var tele:String,
    open var permis:String
)