package com.example.aeon.data.remote.dto.payment

import java.io.Serializable

data class PaymentDto(
    val id: Int,
    val title: String,
    val amount: String,
    val created: String?
) : Serializable
