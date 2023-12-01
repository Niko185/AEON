package com.example.aeon.domain.repository

import com.example.aeon.domain.models.auth.AuthResult
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.models.pay.Payment



interface MainRepository {
    suspend fun getAuthToken(credential: Credential): AuthResult

    suspend fun getPaymentsList(token: AuthResult): List<Payment>
}