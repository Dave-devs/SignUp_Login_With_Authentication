package com.dave_devs.signupandloginwithfirebaseauthentication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.util.Routes.HOME_SCREEN
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.util.Routes.LOGIN_SCREEN
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.util.Routes.SIGNUP_SCREEN
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.util.Routes.WELCOME_SCREEN
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.screens.HomeScreen
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.screens.LoginScreen
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.screens.SignUpScreen
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.screens.WelcomeScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = WELCOME_SCREEN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(WELCOME_SCREEN) {
            WelcomeScreen(
                onNavToLoginScreen = {
                    navController.navigate(LOGIN_SCREEN) {
                        popUpTo(0)
                    }
                }
            )
        }
        composable(LOGIN_SCREEN) {
            LoginScreen(
                onSuccessfulLogin = {
                    navController.navigate(HOME_SCREEN) {
                        popUpTo(0)
                    }
                },
                onSignUpClick = {
                    navController.navigate(SIGNUP_SCREEN) {
                        popUpTo(0)
                    }
                }
            )
        }
        composable(SIGNUP_SCREEN) {
            SignUpScreen(
                onSuccessfulSignUp = {
                   navController.navigate(HOME_SCREEN) {
                       popUpTo(0)
                   }
                },
                onLoginClick = {
                    navController.navigate(LOGIN_SCREEN) {
                        popUpTo(0)
                    }
                }
            )
        }
        composable(HOME_SCREEN) {
            HomeScreen()
        }
    }
}