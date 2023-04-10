package com.example.gestiondriver.Model

import jakarta.persistence.*

@Entity
@Table(name="children")
class Children (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,
    var nom:String,
    var prenom:String,
    var niveau_scholaire:String,
    var age:Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentChildren")
    var parent: Parent
)