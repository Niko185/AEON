package com.example.aeon.presentation.fragment.authorization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aeon.domain.models.auth.AuthResult
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.usecase.GetAuthTokenUseCase
import com.example.aeon.domain.usecase.GetPaymentListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val getAuthTokenUseCase: GetAuthTokenUseCase,
    private val getPaymentListUseCase: GetPaymentListUseCase
): ViewModel() {
     val token = MutableLiveData<String>()

    fun getAuthToken(credential: Credential) {
      viewModelScope.launch {
         val response = getAuthTokenUseCase.execute(credential)
          val authResult = AuthResult(
              token = response.token
          )
          token.postValue(authResult.token)
      }
    }

    fun getPaymentList() {
        viewModelScope.launch {
          val list = getPaymentListUseCase.execute("7b7c0a690bee2e8d90512ed1b57e19f0")
        }
    }

}