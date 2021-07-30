package com.usell.android.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.usell.android.R
import com.usell.android.navigation.ScreenNames
import kotlinx.coroutines.flow.*

class LoginViewModel : ViewModel() {


    private val _login = MutableStateFlow("sasasas")
    private val _password = MutableStateFlow("sasasasas")
    private val _errorResId = MutableStateFlow(NO_ERROR_RES_ID)

    private val _isButtonEnabled = _login.combine(_password) { currentLogin, currentPassword ->
        val isButtonEnabled = currentLogin.isNotEmpty() && (currentPassword.isNotEmpty())
        isButtonEnabled
    }

    val loginText: StateFlow<String> = _login
    val passwordText: StateFlow<String> = _password
    val error: StateFlow<Int> = _errorResId
    val isSignInEnabled: StateFlow<Boolean> = _isButtonEnabled
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), false)

    fun onLoginChange(loginValue: String) {
        _login.value = loginValue
    }

    fun onPassChange(passValue: String) {
        _password.value = passValue
    }

    fun onDoneClicked(navController: NavController) {
        val login = _login.value
        val password = _password.value
        val isLoginEmpty = login.isEmpty()
        val isPassEmpty = password.isEmpty()
        val isPassShort = password.length < MIN_PASSWORD_LENGTH

        val errorMessage = when {
            isLoginEmpty -> R.string.error_login_empty
            isPassEmpty -> R.string.error_password_empty
            isPassShort -> R.string.error_password_short
            else -> null
        }

        if(errorMessage != null) {
            _errorResId.value = errorMessage
            return
        }
        navController.navigate(ScreenNames.MENU)
    }

    companion object {
        private const val NO_ERROR_RES_ID = -1
        private const val MIN_PASSWORD_LENGTH = 4
    }
}