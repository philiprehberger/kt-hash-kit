package com.philiprehberger.hashkit

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

private fun hmac(data: String, key: String, algorithm: String, encoding: HashEncoding): String {
    val mac = Mac.getInstance(algorithm)
    mac.init(SecretKeySpec(key.toByteArray(), algorithm))
    return encode(mac.doFinal(data.toByteArray()), encoding)
}

/** HMAC-SHA256 of this string. */
public fun String.hmacSha256(key: String, encoding: HashEncoding = HashEncoding.HEX): String = hmac(this, key, "HmacSHA256", encoding)
/** HMAC-SHA1 of this string. */
public fun String.hmacSha1(key: String, encoding: HashEncoding = HashEncoding.HEX): String = hmac(this, key, "HmacSHA1", encoding)
/** HMAC-SHA512 of this string. */
public fun String.hmacSha512(key: String, encoding: HashEncoding = HashEncoding.HEX): String = hmac(this, key, "HmacSHA512", encoding)
