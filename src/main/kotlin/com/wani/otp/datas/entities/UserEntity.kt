package com.wani.otp.datas.entities

import javax.persistence.*

@Entity
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Long = 0L,
    var username: String,
    var password: String,
    var roles: String
) {
}