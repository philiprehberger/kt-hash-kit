# Changelog

## [0.1.1] - 2026-03-18

- Upgrade to Kotlin 2.0.21 and Gradle 8.12
- Enable explicitApi() for stricter public API surface
- Add issueManagement to POM metadata

## [0.1.0] - 2026-03-18

### Added

- String extensions: `md5()`, `sha1()`, `sha256()`, `sha512()`, `crc32()`

- ByteArray extensions for hashing

- File extensions with streaming hash (constant memory)

- HMAC: `hmacSha256()`, `hmacSha1()`, `hmacSha512()`

- Incremental `Hasher` builder with `update()` and `digest()`

- `HashEncoding` enum: HEX, HEX_UPPER, BASE64
