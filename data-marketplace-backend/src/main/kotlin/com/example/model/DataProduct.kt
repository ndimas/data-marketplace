package com.example.model

import java.time.LocalDateTime
import java.util.UUID

enum class AccessLevel {
    PUBLIC, INTERNAL, RESTRICTED
}

data class DataProduct(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val category: String,
    val provider: String,
    val accessLevel: AccessLevel,
    val lastUpdated: LocalDateTime = LocalDateTime.now()
)
