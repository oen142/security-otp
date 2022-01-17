package com.wani.otp.util

import org.apache.commons.codec.binary.Base32
import java.security.SecureRandom
import java.util.*

object OTPUtil {

    fun generate(productName: String, username: String): HashMap<String, Any> {
        val map = HashMap<String, Any>()

        val buffer = byteArrayOf(5 + 5 * 5)
        SecureRandom().nextBytes(buffer)
        val codec = Base32()
        val secretKey = buffer.copyOf(10)
        val byteEncodeKey = codec.encode(secretKey)
        val encodedKey = String(byteEncodeKey)
        val url = getQRBarcodeURL(productName, username, encodedKey)
        map["code"] = encodedKey
        map["codeUrl"] = url
        return map
    }

    fun checkCode(otpNumber: String, secretKey: String): Boolean {
        val otpNum = Integer.parseInt(otpNumber)
        val wave = Date().time / 30000
        var result = false
        return result
    }

    private fun verifyCode(): Int {
        return 1
    }


    fun getQRBarcodeURL(productName: String, username: String, secret: String): String =
        "http://chart.apis.google.com/chart?cht=qr&chs=200x200&chl=otpauth://totp/%${productName}${username}%%3Fsecret%%3D${secret}&chld=H|0"

}