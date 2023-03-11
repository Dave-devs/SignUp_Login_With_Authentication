package com.dave_devs.signupandloginwithfirebaseauthentication.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignUpLoginButton(
    modifier: Modifier = Modifier,
    text: String,
    onButtonClick: () -> Unit,
    containerColor: Color,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    contentColor: Color

) {
    Button(
        modifier = modifier,
        onClick = {onButtonClick()},
        shape = RoundedCornerShape(16.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor,
            disabledContentColor = contentColor
        )
    ) {
       if(isLoading) {
           CircularProgressIndicator(
               color = containerColor,
               modifier = Modifier.size(24.dp)
           )
       } else {
           Text(
               text = text,
               style = MaterialTheme.typography.bodySmall
           )
       }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpLoginButtonPreview() {
    SignUpLoginButton(
      text = "Log in",
      onButtonClick = { },
      containerColor = MaterialTheme.colorScheme.primaryContainer,
      contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    )
}