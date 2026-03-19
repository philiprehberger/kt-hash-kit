# Changelog

## [0.1.0] - 2026-03-18

### Added

- String extensions: `md5()`, `sha1()`, `sha256()`, `sha512()`, `crc32()`

- ByteArray extensions for hashing

- File extensions with streaming hash (constant memory)

- HMAC: `hmacSha256()`, `hmacSha1()`, `hmacSha512()`

- Incremental `Hasher` builder with `update()` and `digest()`

- `HashEncoding` enum: HEX, HEX_UPPER, BASE64
