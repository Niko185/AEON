package com.example.aeon.data.remote.api

import com.example.aeon.domain.models.auth.AuthResult
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.models.pay.Payment
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface AeonApi {
    @POST("login")
    @Headers("app-key: 12345", "v: 1")
    suspend fun getAuthToken(@Body credential: Credential): AuthResult

    @GET("payments")
    suspend fun getPaymentList(@Header("token") token: String): List<Payment>
}

