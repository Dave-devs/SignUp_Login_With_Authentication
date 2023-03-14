package com.dave_devs.signupandloginwithfirebaseauthentication.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.VpnLock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.components.BubbleAnimation
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.components.EditTextField
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.components.HeaderBackground
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.components.SignUpLoginButton
import com.dave_devs.signupandloginwithfirebaseauthentication.core.navigation.NavDestinationHelper
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.viewmodel.LoginViewModel
import com.dave_devs.signupandloginwithfirebaseauthentication.ui.theme.Gray20
import com.dave_devs.signupandloginwithfirebaseauthentication.ui.theme.Green30
import com.dave_devs.signupandloginwithfirebaseauthentication.ui.theme.Green40

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSuccessfulLogin: () ->Unit,
    onSignUpClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    NavDestinationHelper(
        shouldNavigate = {
            viewModel.loginState.isSuccessfullyLoggedIn
        },
        destination = {
            onSuccessfulLogin()
        }
    )
    Box(
        modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentAlignment = Alignment.Center
        ) {
            HeaderBackground(
                leftColor = Green30,
                rightColor = Green40,
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        LoginTextFields(
            nameValue = { viewModel.loginState.nameInput },
            emailValue = { viewModel.loginState.emailInput },
            passwordValue = { viewModel.loginState.passwordInput },
            buttonEnabled = { viewModel.loginState.isInputValid },
            onNameChange = viewModel::onNameInputChange,
            onEmailChanged = viewModel::onEmailInputChange,
            onPasswordChanged = viewModel::onPasswordInputChange,
            onLoginButtonClick = viewModel::onLoginClicked,
            isPasswordShown = { viewModel.loginState.isPasswordShown },
            onTrailingPasswordIconClick = viewModel::onToggleVisibilityTransformation,
            errorHint = { viewModel.loginState.errorMessageInput },
            isLoading = { viewModel.loginState.isLoading },
            modifier = Modifier
                .padding(top = 200.dp)
                .fillMaxWidth(0.9f)
                .shadow(5.dp, RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.background, RoundedCornerShape(15.dp))
                .padding(10.dp, 15.dp, 10.dp, 5.dp)
                .align(Alignment.TopCenter)
        )
        BubbleAnimation(
            bubbleColor1 = Green30,
            bubbleColor2 = Green40,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .align(Alignment.BottomCenter)
        )
        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have an account?",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.width(3.dp))
            Text(
                text = " Sign up",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable {
                        onSignUpClick()
                    },
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Composable
fun LoginTextFields(
    nameValue: () -> String,
    emailValue:() -> String,
    passwordValue:()-> String,
    buttonEnabled:() -> Boolean,
    onNameChange: (String) -> Unit,
    onEmailChanged:(String) -> Unit,
    onPasswordChanged:(String) -> Unit,
    onLoginButtonClick:()->Unit,
    isPasswordShown:()->Boolean,
    onTrailingPasswordIconClick: () -> Unit,
    errorHint:()->String?,
    isLoading:()->Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        EditTextField(
            valueText = nameValue(),
            hint = "Name",
            textColor = Gray20,
            onValueChanged = onNameChange,
            leadingIcon = null,
            onTrailingIconClicked = null,
            cursorColor = MaterialTheme.colorScheme.outline
        )
        EditTextField(
            valueText = emailValue(),
            hint = "Email",
            textColor = Gray20,
            onValueChanged = onEmailChanged,
            leadingIcon = Icons.Default.Email,
            onTrailingIconClicked = null,
            cursorColor = MaterialTheme.colorScheme.outline
        )
        EditTextField(
            valueText = passwordValue(),
            hint = "Password",
            textColor = Gray20,
            onValueChanged = onPasswordChanged,
            leadingIcon = Icons.Default.VpnLock,
            trailingIcon = Icons.Default.RemoveRedEye,
            onTrailingIconClicked = { onTrailingPasswordIconClick() },
            cursorColor = MaterialTheme.colorScheme.outline,
            visualTransformation = if(isPasswordShown()){
                VisualTransformation.None
            }else PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            SignUpLoginButton(
                text = "Login",
                onButtonClick = onLoginButtonClick,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                enabled = buttonEnabled(),
                isLoading = isLoading(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .shadow(5.dp, RoundedCornerShape(25.dp))
            )
            Text(
                errorHint() ?: "",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}