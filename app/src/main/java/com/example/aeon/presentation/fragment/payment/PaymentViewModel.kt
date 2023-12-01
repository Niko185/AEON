package com.example.aeon.presentation.fragment.payment

import androidx.lifecycle.ViewModel
import com.example.aeon.domain.usecase.GetAuthTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val authTokenUseCase: GetAuthTokenUseCase
): ViewModel() {
}