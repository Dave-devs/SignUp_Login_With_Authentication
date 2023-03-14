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
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.viewmodel.SignUpViewModel
import com.dave_devs.signupandloginwithfirebaseauthentication.ui.theme.Gray20
import com.dave_devs.signupandloginwithfirebaseauthentication.ui.theme.Green30
import com.dave_devs.signupandloginwithfirebaseauthentication.ui.theme.Green40

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSuccessfulSignUp: () ->Unit,
    onLoginClick: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    NavDestinationHelper(
        shouldNavigate = {
            viewModel.signUpState.isSuccessfullySignedUp
        },
        destination = {
            onSuccessfulSignUp()
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
                text = "Sign Up",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        SignUpTextFields(
            nameValue = { viewModel.signUpState.nameInput },
            emailValue = { viewModel.signUpState.emailInput },
            passwordValue = { viewModel.signUpState.passwordInput },
            repeatedPasswordValue = { viewModel.signUpState.repeatedPasswordInput },
            buttonEnabled = { viewModel.signUpState.isInputValid },
            onNameChange = viewModel::onNameInputChange,
            onEmailChanged = viewModel::onEmailInputChange,
            onPasswordChanged = viewModel::onPasswordInputChange,
            onRepeatedPasswordChanged = viewModel::onRepeatedPasswordInputChange,
            onSignUpButtonClick = viewModel::onSignUpClicked,
            isPasswordShown = { viewModel.signUpState.isPasswordShown },
            isRepeatedPasswordShown = { viewModel.signUpState.isRepeatedPasswordShown },
            onTrailingPasswordIconClick = viewModel::onToggleVisibilityTransformation,
            onTrailingRepeatedPasswordIconClick = viewModel::onToggleVisibilityTransformation,
            errorHint = { viewModel.signUpState.errorMessageInput },
            isLoading = { viewModel.signUpState.isLoading },
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
                .height(220.dp)
                .align(Alignment.BottomCenter),
        )
        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account?",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.width(3.dp))
            Text(
                text = "Login",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable {
                        onLoginClick()
                    },
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Composable
fun SignUpTextFields(
    nameValue: () -> String,
    emailValue:() -> String,
    passwordValue:()-> String,
    repeatedPasswordValue:() -> String,
    buttonEnabled:() -> Boolean,
    onNameChange: (String) -> Unit,
    onEmailChanged:(String) -> Unit,
    onPasswordChanged:(String) -> Unit,
    onRepeatedPasswordChanged:(String) -> Unit,
    onSignUpButtonClick:()->Unit,
    isPasswordShown:()->Boolean,
    isRepeatedPasswordShown:()->Boolean,
    onTrailingPasswordIconClick: () -> Unit,
    onTrailingRepeatedPasswordIconClick: ()->Unit,
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
            cursorColor = MaterialTheme.colorScheme.outline,
            modifier = Modifier.fillMaxWidth()
        )
        EditTextField(
            valueText = emailValue(),
            hint = "Email",
            textColor = Gray20,
            onValueChanged = onEmailChanged,
            leadingIcon = Icons.Default.Email,
            onTrailingIconClicked = null,
            cursorColor = MaterialTheme.colorScheme.outline,
            modifier = Modifier.fillMaxWidth()
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
            keyboardType = KeyboardType.Password,
            modifier = Modifier.fillMaxWidth()
        )
        EditTextField(
            valueText = repeatedPasswordValue(),
            hint = "Repeat Password",
            textColor = Gray20,
            onValueChanged = onRepeatedPasswordChanged,
            leadingIcon = Icons.Default.VpnLock,
            trailingIcon = Icons.Default.RemoveRedEye,
            onTrailingIconClicked = { onTrailingRepeatedPasswordIconClick() },
            cursorColor = MaterialTheme.colorScheme.outline,
            visualTransformation = if(isRepeatedPasswordShown()){
                VisualTransformation.None
            }else PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            SignUpLoginButton(
                text = "Login",
                onButtonClick = onSignUpButtonClick,
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
