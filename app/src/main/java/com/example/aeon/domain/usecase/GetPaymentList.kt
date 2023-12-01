package com.example.aeon.domain.usecase

import com.example.aeon.domain.models.auth.AuthResult
import com.example.aeon.domain.models.pay.Payment
import com.example.aeon.domain.repository.MainRepository
import javax.inject.Inject

class GetPaymentList @Inject constructor(
    private val mainRepository: MainRepository
){
    suspend fun execute(token: AuthResult): List<Payment>{
        return mainRepository.getPaymentsList(token)
    }
}