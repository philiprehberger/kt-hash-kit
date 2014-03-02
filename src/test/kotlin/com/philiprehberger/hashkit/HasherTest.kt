package com.philiprehberger.hashkit

import kotlin.test.*

class HasherTest {
    @Test fun `incremental matches single pass`() {
        val singlePass = "helloworld".sha256()
        val incremental = Hasher.sha256().update("hello").update("world").digest()
        assertEquals(singlePass, incremental)
    }
}
