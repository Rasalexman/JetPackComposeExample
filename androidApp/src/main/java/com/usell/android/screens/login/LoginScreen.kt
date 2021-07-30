package com.usell.android.screens.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.usell.android.R

@Composable
fun Login(navController: NavController, viewModel: LoginViewModel = viewModel()) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val onClickSignIn = {
            viewModel.onDoneClicked(navController)
        }
        val login: String by viewModel.loginText.collectAsState()
        OutlinedTextField(
            value = login,
            onValueChange = viewModel::onLoginChange,
            label = { Text(stringResource(id = R.string.label_login)) },
            modifier = Modifier.padding(top = 16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        val pass: String by viewModel.passwordText.collectAsState()
        OutlinedTextField(
            value = pass,
            onValueChange = viewModel::onPassChange,
            label = { Text(stringResource(id = R.string.label_password)) },
            modifier = Modifier.padding(top = 16.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                onClickSignIn()
            })
        )

        val isButtonEnabled: Boolean by viewModel.isSignInEnabled.collectAsState(initial = false)
        Button(
            onClick = onClickSignIn,
            modifier = Modifier.padding(top = 16.dp),
            enabled = isButtonEnabled
        ) {
            Text(text = stringResource(id = R.string.button_signin))
        }

        val error: Int by viewModel.error.collectAsState()
        if(error > 0) {
            val context = LocalContext.current
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        }
    }
}