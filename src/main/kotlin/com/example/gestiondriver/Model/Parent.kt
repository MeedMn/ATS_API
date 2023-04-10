package com.example.gestiondriver.Model

import jakarta.persistence.*


@Entity
@Table(name="parent")
class Parent (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,
    var nom:String,
    var prenom:String,
    var numero:String,
    var address:String,
    @OneToMany
    @JoinColumn(name = "Parent")
    var children: List<Children>

)
