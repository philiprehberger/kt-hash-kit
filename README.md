# hash-kit

[![CI](https://github.com/philiprehberger/kt-hash-kit/actions/workflows/publish.yml/badge.svg)](https://github.com/philiprehberger/kt-hash-kit/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.philiprehberger/hash-kit)](https://central.sonatype.com/artifact/com.philiprehberger/hash-kit)
[![License](https://img.shields.io/github/license/philiprehberger/kt-hash-kit)](LICENSE)

Hashing utilities: MD5, SHA-256, SHA-512, HMAC, CRC32 with hex and base64 encoding.

## Installation

### Gradle (Kotlin DSL)

```kotlin
dependencies {
    implementation("com.philiprehberger:hash-kit:0.1.2")
}
```

### Maven

```xml
<dependency>
    <groupId>com.philiprehberger</groupId>
    <artifactId>hash-kit</artifactId>
    <version>0.1.2</version>
</dependency>
```

## Usage

```kotlin
import com.philiprehberger.hashkit.*

"hello".md5()       // "5d41402abc4b2a76b9719d911017c592"
"hello".sha256()    // "2cf24dba5fb0a30e..."
"hello".sha256(HashEncoding.BASE64)  // base64 encoded

// File hashing (streaming)
File("data.bin").sha256()

// HMAC
"message".hmacSha256("secret-key")

// Incremental
Hasher.sha256().update("part1").update("part2").digest()
```

## API

| Function / Class | Description |
|------------------|-------------|
| `String.md5(encoding)` | MD5 hash |
| `String.sha256(encoding)` | SHA-256 hash |
| `String.sha512(encoding)` | SHA-512 hash |
| `String.crc32()` | CRC32 checksum |
| `File.sha256(encoding)` | Streaming file hash |
| `String.hmacSha256(key, encoding)` | HMAC-SHA256 |
| `Hasher.sha256()` | Incremental hash builder |
| `HashEncoding` | Output format: HEX, HEX_UPPER, BASE64 |

## Development

```bash
./gradlew test       # Run tests
./gradlew build      # Build JAR
```

## License

MIT
