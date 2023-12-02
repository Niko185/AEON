package com.example.aeon.domain.repository

import com.example.aeon.data.remote.dto.payment.PaymentDto
import com.example.aeon.domain.models.auth.AuthResult
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.models.payment.Payment
import com.example.aeon.domain.models.payment.PaymentResult


interface MainRepository {
    suspend fun getAuthToken(credential: Credential): AuthResult

    suspend fun getPaymentsList(token: String): PaymentResult
}