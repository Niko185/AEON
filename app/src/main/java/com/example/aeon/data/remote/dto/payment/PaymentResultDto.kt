package com.example.aeon.data.remote.dto.payment

import com.example.aeon.domain.models.payment.Payment
import com.example.aeon.domain.models.payment.PaymentResult
import java.io.Serializable



data class PaymentResultDto(
    val success: String,
    val response: List<PaymentDto>
): Serializable {
    fun mapToDomain(): PaymentResult {
        val paymentList = response.map {
            Payment(
                id = it.id.toString(),
                title = it.title,
                amount = it.amount,
                created = it.created.toString()
            )
        }
        return PaymentResult(paymentList)
    }

}
