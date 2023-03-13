package com.dave_devs.signupandloginwithfirebaseauthentication.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dave_devs.signupandloginwithfirebaseauthentication.R
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.components.EditTextField
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.components.SignUpLoginButton
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.navigation.NavDestinationHelper
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.viewmodel.SignUpViewModel
import com.dave_devs.signupandloginwithfirebaseauthentication.ui.theme.Gray20
import com.dave_devs.signupandloginwithfirebaseauthentication.ui.theme.Red40

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSuccessfulSignUp: () ->Unit,
    onNavToLoginScreen: () -> Unit,
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
        SignUpTopComponent()
        Spacer(Modifier.height(16.dp))
        SignUpTextFields(
            nameValue = {viewModel.signUpState.nameInput},
            emailValue = {viewModel.signUpState.emailInput},
            passwordValue = {viewModel.signUpState.passwordInput},
            repeatedPassword = {viewModel.signUpState.repeatedPasswordInput},
            buttonEnabled = {viewModel.signUpState.isInputValid},
            onNameChange = viewModel::onNameInputChange,
            onEmailChanged = viewModel::onEmailInputChange,
            onPasswordChanged = viewModel::onPasswordInputChange,
            onRepeatedPasswordChanged = viewModel::onRepeatedPasswordInputChange,
            onLoginButtonClick = viewModel::onSignUpClicked,
            isPasswordShown = {viewModel.signUpState.isPasswordShown},
            onTrailingPasswordIconClick = viewModel::onToggleVisibilityTransformation,
            errorHint = {viewModel.signUpState.errorMessageInput},
            isLoading = {viewModel.signUpState.isLoading},
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = MaterialTheme.typography.labelSmall.fontSize
            )
            Spacer(Modifier.width(3.dp))
            Text(
                text = " Sign up",
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                color = Red40,
                modifier = Modifier.clickable{onNavToLoginScreen()}
            )
        }
        Spacer(Modifier.height(16.dp))
        Column {
            Text(
                text = "Or sign up with",
                fontSize = MaterialTheme.typography.labelSmall.fontSize
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.gmail_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.twitter_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun SignUpTopComponent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SignUp now",
            fontSize = MaterialTheme.typography.displayMedium.fontSize,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "SignUp to continue using our app",
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SignUpTextFields(
    nameValue: () -> String,
    emailValue:() -> String,
    passwordValue:()-> String,
    repeatedPassword:() -> String,
    buttonEnabled:() -> Boolean,
    onNameChange: (String) -> Unit,
    onEmailChanged:(String) -> Unit,
    onPasswordChanged:(String) -> Unit,
    onRepeatedPasswordChanged:(String) -> Unit,
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
        EditTextField(
            valueText = repeatedPassword(),
            hint = "Repeat Password",
            textColor = Gray20,
            onValueChanged = onRepeatedPasswordChanged,
            leadingIcon = Icons.Default.VpnLock,
            trailingIcon = Icons.Default.RemoveRedEye,
            onTrailingIconClicked = { onTrailingPasswordIconClick() },
            cursorColor = MaterialTheme.colorScheme.outline,
            visualTransformation = if(isPasswordShown()){
                VisualTransformation.None
            }else PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password
        )
        Text(
            text = "Password must be minimum of 10 characters.",
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            textAlign = TextAlign.Start
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
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
                    .shadow(5.dp, RoundedCornerShape(25.dp)),
            )
            Text(
                text = errorHint() ?: "",
                fontSize = MaterialTheme.typography.labelSmall.fontSize
            )
        }
    }
}
