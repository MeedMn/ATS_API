package com.example.gestiondriver.Model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
@Inheritance
@Entity
@Table(name="driver")
open class Driver{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id:Int?=null
    open var lastname:String?=null
    open var firstname:String?=null
    open var address:String?=null
    open var age:Int?=null
    @Column(unique = true)
    open var code:String?=null
    open var numberphone:String?=null
    open var licence:String?=null
    @Column(insertable=false, updatable=false)
    open var dtype:String?=null
}