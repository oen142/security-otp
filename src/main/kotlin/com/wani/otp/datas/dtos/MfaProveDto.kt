package com.wani.otp.datas.dtos

data class MfaProveDto(
    val secretKey: String,
    val type: String
) {
}