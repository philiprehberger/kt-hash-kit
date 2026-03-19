package com.philiprehberger.hashkit

import java.security.MessageDigest
import java.util.Base64
import java.util.zip.CRC32

internal fun encode(bytes: ByteArray, encoding: HashEncoding): String = when (encoding) {
    HashEncoding.HEX -> bytes.joinToString("") { "%02x".format(it) }
    HashEncoding.HEX_UPPER -> bytes.joinToString("") { "%02X".format(it) }
    HashEncoding.BASE64 -> Base64.getEncoder().encodeToString(bytes)
}

internal fun hashBytes(input: ByteArray, algorithm: String, encoding: HashEncoding): String {
    val digest = MessageDigest.getInstance(algorithm)
    return encode(digest.digest(input), encoding)
}

/** MD5 hash of this string. */
public fun String.md5(encoding: HashEncoding = HashEncoding.HEX): String = hashBytes(toByteArray(), "MD5", encoding)
/** SHA-1 hash of this string. */
public fun String.sha1(encoding: HashEncoding = HashEncoding.HEX): String = hashBytes(toByteArray(), "SHA-1", encoding)
/** SHA-256 hash of this string. */
public fun String.sha256(encoding: HashEncoding = HashEncoding.HEX): String = hashBytes(toByteArray(), "SHA-256", encoding)
/** SHA-512 hash of this string. */
public fun String.sha512(encoding: HashEncoding = HashEncoding.HEX): String = hashBytes(toByteArray(), "SHA-512", encoding)
/** CRC32 checksum of this string. */
public fun String.crc32(): Long { val c = CRC32(); c.update(toByteArray()); return c.value }

/** MD5 hash of this byte array. */
public fun ByteArray.md5(encoding: HashEncoding = HashEncoding.HEX): String = hashBytes(this, "MD5", encoding)
/** SHA-256 hash of this byte array. */
public fun ByteArray.sha256(encoding: HashEncoding = HashEncoding.HEX): String = hashBytes(this, "SHA-256", encoding)
/** SHA-512 hash of this byte array. */
public fun ByteArray.sha512(encoding: HashEncoding = HashEncoding.HEX): String = hashBytes(this, "SHA-512", encoding)
