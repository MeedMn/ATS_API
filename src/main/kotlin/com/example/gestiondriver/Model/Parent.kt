package com.example.gestiondriver.Model

import jakarta.persistence.*


@Entity
@Table(name="parent")
class Parent (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,
    var lastname:String,
    var firstname:String,
    var numberphone:String,
    var address:String,
    var longitude:String,
    var latitude:String,
    @OneToMany
    @JoinColumn(name="id_parent")
    var student: List<Student> = emptyList()

) {

}
