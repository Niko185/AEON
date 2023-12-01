package com.example.aeon.presentation.fragment.authorization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.usecase.GetAuthTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val getAuthTokenUseCase: GetAuthTokenUseCase
): ViewModel() {


    fun getAuthToken(credential: Credential) {
      viewModelScope.launch {
          val response = getAuthTokenUseCase.execute(credential)
      }

    }

}