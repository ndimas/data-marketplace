package com.example.service

import jakarta.enterprise.context.ApplicationScoped
import java.util.Base64

@ApplicationScoped
class AuthenticationService {
    private val hardcodedUser = "admin"
    private val hardcodedPassword = "password"

    fun authenticate(authHeader: String?): Boolean {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return false
        }

        val base64Credentials = authHeader.substring("Basic ".length)
        val decodedCredentials = String(Base64.getDecoder().decode(base64Credentials))
        val parts = decodedCredentials.split(":", limit = 2)

        if (parts.size != 2) {
            return false
        }

        val username = parts[0]
        val password = parts[1]

        return username == hardcodedUser && password == hardcodedPassword
    }

    fun generateBasicAuthHeader(): String {
        val credentials = "$hardcodedUser:$hardcodedPassword"
        val encodedCredentials = Base64.getEncoder().encodeToString(credentials.toByteArray())
        return "Basic $encodedCredentials"
    }
}
