package com.example.aeon.presentation.fragment.authorization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.example.aeon.R
import com.example.aeon.domain.models.auth.AuthResult
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.models.payment.Payment
import com.example.aeon.domain.usecase.GetAuthTokenUseCase
import com.example.aeon.domain.usecase.GetPaymentListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val getAuthTokenUseCase: GetAuthTokenUseCase,
    private val getPaymentListUseCase: GetPaymentListUseCase
) : ViewModel() {
    val paymentList = MutableLiveData<List<Payment>>()

    fun getAuthToken(credential: Credential) {
        viewModelScope.launch {
            val response = getAuthTokenUseCase.execute(credential)
            val authResult = AuthResult(token = response.token)
            getPaymentList(authResult.token)
        }
    }

    private fun getPaymentList(token: String) {
        viewModelScope.launch {
            val list = getPaymentListUseCase.execute(token)
            paymentList.postValue(list.paymentList)
        }
    }

}