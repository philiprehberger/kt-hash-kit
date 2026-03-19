package com.philiprehberger.hashkit

import java.io.File
import java.security.DigestInputStream
import java.security.MessageDigest

private fun hashFile(file: File, algorithm: String, encoding: HashEncoding): String {
    val digest = MessageDigest.getInstance(algorithm)
    DigestInputStream(file.inputStream(), digest).use { dis ->
        val buf = ByteArray(8192)
        while (dis.read(buf) != -1) { /* drain */ }
    }
    return encode(digest.digest(), encoding)
}

/** MD5 hash of this file (streamed). */
public fun File.md5(encoding: HashEncoding = HashEncoding.HEX): String = hashFile(this, "MD5", encoding)
/** SHA-256 hash of this file (streamed). */
public fun File.sha256(encoding: HashEncoding = HashEncoding.HEX): String = hashFile(this, "SHA-256", encoding)
/** SHA-512 hash of this file (streamed). */
public fun File.sha512(encoding: HashEncoding = HashEncoding.HEX): String = hashFile(this, "SHA-512", encoding)
