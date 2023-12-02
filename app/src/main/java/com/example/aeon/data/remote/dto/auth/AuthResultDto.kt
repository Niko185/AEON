package com.example.aeon.data.remote.dto.auth

import com.example.aeon.domain.models.auth.AuthResult

data class AuthResultDto(
    val success: String,
    val response: AuthTokenDto
) {
    fun mapToDomain(): AuthResult {
        return AuthResult(
            token = response.token
        )
    }
}

