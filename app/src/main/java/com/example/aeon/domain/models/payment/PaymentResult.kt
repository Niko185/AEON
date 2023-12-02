package com.example.aeon.domain.models.payment

import retrofit2.Response
import java.io.Serializable

data class PaymentResult (
    val paymentList: List<Payment>
    ) : Serializable