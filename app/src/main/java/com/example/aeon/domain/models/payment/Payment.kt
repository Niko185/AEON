package com.example.aeon.domain.models.payment

import java.io.Serializable

data class Payment(
    val id: String,
    val title: String,
    val amount: String?,
    val created: String?
): Serializable
