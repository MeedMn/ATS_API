package com.example.gestiondriver.Model

import jakarta.persistence.*

@Entity
@Table(name="transport")
class Transport (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,
    var matricule:String,
    var carburant:String,
    var nombre_de_place:Int,
    @OneToOne
    @JoinColumn(name = "driver")
    val id_driver:Driver,
    @OneToOne
    @JoinColumn(name="codriver")
    val id_CoDriver:Co_Driver
)