package com.dave_devs.signupandloginwithfirebaseauthentication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.util.Routes.LOGIN_SCREEN
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.util.Routes.SIGNUP_SCREEN
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.util.Routes.WELCOME_SCREEN

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

        }
        composable(LOGIN_SCREEN) {

        }
        composable(SIGNUP_SCREEN) {

        }
    }
}