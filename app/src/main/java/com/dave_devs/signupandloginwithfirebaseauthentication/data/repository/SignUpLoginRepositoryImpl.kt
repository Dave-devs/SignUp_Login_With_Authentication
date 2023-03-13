package com.dave_devs.signupandloginwithfirebaseauthentication.data.repository

import com.dave_devs.signupandloginwithfirebaseauthentication.domain.repository.SignUpLoginRepository
import kotlinx.coroutines.delay

class SignUpLoginRepositoryImpl: SignUpLoginRepository {
    override suspend fun signupAuth(name: String, email: String, password: String): Boolean {
        delay(1000)
        return true
    }

    override suspend fun loginAuth(name: String, email: String, password: String): Boolean {
        delay(1000)
        return true
    }
}