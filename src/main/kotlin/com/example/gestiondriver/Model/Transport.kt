package com.example.gestiondriver.Model

import jakarta.persistence.*

@Entity
@Table(name="transport")
class Transport (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,
    var registration_number:String,
    var fuel:String,
    var seat_number:Int,
    @OneToOne
    @JoinColumn(name = "driver")
    var id_driver:Driver,
    @OneToOne
    @JoinColumn(name="codriver")
    var id_CoDriver:Co_Driver
)