package com.example.aeon.data.repository

import com.example.aeon.data.remote.api.AeonApi
import com.example.aeon.domain.models.auth.AuthResult
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.models.pay.Payment
import com.example.aeon.domain.repository.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(private val aeonApi: AeonApi): MainRepository {
    override suspend fun getAuthToken(credential: Credential): AuthResult {
        return aeonApi.getAuthToken(credential)
    }

    override suspend fun getPaymentsList(authResult: AuthResult): List<Payment> {
        return aeonApi.getPaymentList(authResult.token)
    }

}