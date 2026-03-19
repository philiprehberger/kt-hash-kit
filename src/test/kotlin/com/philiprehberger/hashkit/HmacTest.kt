package com.philiprehberger.hashkit

import kotlin.test.*

class HmacTest {
    @Test fun `hmacSha256`() { val result = "message".hmacSha256("secret"); assertTrue(result.length == 64) }
    @Test fun `hmacSha1`() { val result = "message".hmacSha1("secret"); assertTrue(result.length == 40) }
    @Test fun `different keys produce different hmacs`() { assertNotEquals("msg".hmacSha256("key1"), "msg".hmacSha256("key2")) }
}
