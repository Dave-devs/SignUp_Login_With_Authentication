package com.dave_devs.signupandloginwithfirebaseauthentication.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dave_devs.signupandloginwithfirebaseauthentication.R

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    buttonText: String,
    buttonColor: Color,
    description: String,
    textColor: Color,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.height(110.dp))
        Image(
            painter = painterResource(id = R.drawable.welcome_amico),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier.size(230.dp)
        )
        Spacer(Modifier.height(55.dp))
        Text(
            text = "Welcome",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = description,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            softWrap = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )
        Spacer(Modifier.height(180.dp))
        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .fillMaxWidth()
                .size(50.dp)
                .padding(start = 10.dp, end = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor,
                contentColor = textColor
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 3.dp
            )
        ) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(Modifier.height(10.dp))
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.Center
       ) {
           Text(
               text = "Already have and account?",
               style = MaterialTheme.typography.bodyLarge,
               fontWeight = FontWeight.Normal,
               color = Color.Gray
           )
           Spacer(Modifier.width(4.dp))
           Text(
               text = "Log in",
               style = MaterialTheme.typography.bodyLarge,
               fontWeight = FontWeight.SemiBold,
               color = MaterialTheme.colorScheme.primary
           )
       }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(
        buttonText = "Get Started",
        buttonColor = MaterialTheme.colorScheme.primary,
        description = "Lorem ipsum dolorsitamet elitseddo consectetur adipiscing" +
                "eiusmod tempor incididunt utlabore etdolore magnaaliqua.",
        textColor = MaterialTheme.colorScheme.onPrimary,
        onButtonClick = {}
    )
}