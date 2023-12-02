package com.example.aeon.data.repository

import com.example.aeon.data.remote.api.AeonApi
import com.example.aeon.data.remote.dto.payment.PaymentDto
import com.example.aeon.domain.models.auth.AuthResult
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.models.payment.Payment
import com.example.aeon.domain.models.payment.PaymentResult
import com.example.aeon.domain.repository.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(private val aeonApi: AeonApi): MainRepository {
    override suspend fun getAuthToken(credential: Credential): AuthResult {
        val responseDto = aeonApi.getAuthToken(credential)
        return responseDto.mapToDomain()
    }

    override suspend fun getPaymentsList(token: String): PaymentResult {
        val responseDto = aeonApi.getPaymentList(token)
        return responseDto.mapToDomain()
        }
    }
