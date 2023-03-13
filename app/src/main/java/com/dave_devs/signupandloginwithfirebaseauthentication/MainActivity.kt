package com.dave_devs.signupandloginwithfirebaseauthentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.navigation.Navigation
import com.dave_devs.signupandloginwithfirebaseauthentication.ui.theme.SignUpAndLoginWithFirebaseAuthenticationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpAndLoginWithFirebaseAuthenticationTheme {
                Navigation()
            }
        }
    }
}