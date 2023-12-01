package com.example.aeon.domain.usecase

import com.example.aeon.domain.models.auth.AuthResult
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.repository.MainRepository
import javax.inject.Inject

class GetAuthTokenUseCase @Inject constructor(
   private val mainRepository: MainRepository
) {
    suspend fun execute(credential: Credential): AuthResult {
        return mainRepository.getAuthToken(credential)
    }
}