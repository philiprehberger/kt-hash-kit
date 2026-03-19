package com.philiprehberger.hashkit

import kotlin.test.*

class HashExtensionsTest {
    @Test fun `md5`() = assertEquals("5d41402abc4b2a76b9719d911017c592", "hello".md5())
    @Test fun `sha256`() = assertEquals("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824", "hello".sha256())
    @Test fun `sha256 base64`() = assertTrue("hello".sha256(HashEncoding.BASE64).isNotEmpty())
    @Test fun `sha256 hex upper`() = assertEquals("hello".sha256().uppercase(), "hello".sha256(HashEncoding.HEX_UPPER))
    @Test fun `crc32`() = assertTrue("hello".crc32() > 0)
    @Test fun `byte array`() = assertEquals("hello".sha256(), "hello".toByteArray().sha256())
}
