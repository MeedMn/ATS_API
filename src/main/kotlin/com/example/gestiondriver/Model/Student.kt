package com.example.gestiondriver.Model

import jakarta.persistence.*

@Entity
@Table(name="student")
class Student (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,
    var lastname:String,
    var firstname:String,
    var grade:String,
    var age:Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentChildren")
    var parent: Parent
)