package com.dave_devs.signupandloginwithfirebaseauthentication.domain.repository

interface SignUpLoginRepository {

    suspend fun signupAuth(name: String, email: String, password: String): Boolean
    suspend fun loginAuth(name: String, email: String, password: String): Boolean
}