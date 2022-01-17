package com.wani.otp.datas.entities

import javax.persistence.*

@Entity
class MfaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mfa_id")
    var id: Long = 0L,

    var username: String,
    var secretKey: String,
    var type: String
)