package com.example.aeon.domain.usecase

import com.example.aeon.domain.models.payment.Payment
import com.example.aeon.domain.models.payment.PaymentResult
import com.example.aeon.domain.repository.MainRepository
import javax.inject.Inject

class GetPaymentListUseCase @Inject constructor(
    private val mainRepository: MainRepository
){
    suspend fun execute(token: String): PaymentResult {
        return mainRepository.getPaymentsList(token)
    }
}