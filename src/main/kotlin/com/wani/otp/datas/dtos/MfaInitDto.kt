package com.wani.otp.datas.dtos


data class MfaInitDto(
    val username: String,
    val secretKey: String,
    val type: String
) {
}