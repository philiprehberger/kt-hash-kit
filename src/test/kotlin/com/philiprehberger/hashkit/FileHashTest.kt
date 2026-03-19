package com.philiprehberger.hashkit

import java.io.File
import kotlin.test.*

class FileHashTest {
    @Test fun `file hash matches string hash`() {
        val tmp = File.createTempFile("hashtest", ".txt")
        tmp.writeText("hello")
        try { assertEquals("hello".sha256(), tmp.sha256()) } finally { tmp.delete() }
    }
}
