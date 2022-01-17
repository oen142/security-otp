package com.wani.otp.datas.dtos

data class MfaDto(
    val id: Long,
    val username: String,
    val secretKey: String,
    val type: String,
    val otpNumber: String
) {

}