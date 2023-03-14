package com.dave_devs.signupandloginwithfirebaseauthentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dave_devs.signupandloginwithfirebaseauthentication.core.navigation.Navigation
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