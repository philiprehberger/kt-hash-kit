package com.philiprehberger.hashkit

import java.security.MessageDigest

/** Incremental hasher for building hash from multiple updates. */
public class Hasher private constructor(private val digest: MessageDigest, private val encoding: HashEncoding) {
    /** Update with string data. */
    public fun update(data: String): Hasher { digest.update(data.toByteArray()); return this }
    /** Update with byte array data. */
    public fun update(data: ByteArray): Hasher { digest.update(data); return this }
    /** Finalize and return the hash string. */
    public fun digest(): String = encode(digest.digest(), encoding)

    public companion object {
        /** Create a SHA-256 incremental hasher. */
        public fun sha256(encoding: HashEncoding = HashEncoding.HEX): Hasher = Hasher(MessageDigest.getInstance("SHA-256"), encoding)
        /** Create a MD5 incremental hasher. */
        public fun md5(encoding: HashEncoding = HashEncoding.HEX): Hasher = Hasher(MessageDigest.getInstance("MD5"), encoding)
        /** Create a SHA-512 incremental hasher. */
        public fun sha512(encoding: HashEncoding = HashEncoding.HEX): Hasher = Hasher(MessageDigest.getInstance("SHA-512"), encoding)
    }
}
