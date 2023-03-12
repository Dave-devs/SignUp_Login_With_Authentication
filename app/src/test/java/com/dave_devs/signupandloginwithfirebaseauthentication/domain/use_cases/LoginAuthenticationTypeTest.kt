package com.dave_devs.signupandloginwithfirebaseauthentication.domain.use_cases

import com.dave_devs.signupandloginwithfirebaseauthentication.domain.LoginAuthenticationType
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginAuthenticationTypeTest {
    private val loginAuthenticationUseCase = LoginAuthenticationUseCase()

    @Test
    fun `test login input return valid`() {
        val result = loginAuthenticationUseCase(
            name = "John Deo", email = "Johndeo@gmail.com", passWord = "SignUp/Login"
        )
        assertThat(result).isEqualTo(LoginAuthenticationType.Valid)
    }
    @Test
    fun `test login input return empty field`() {
        val result = loginAuthenticationUseCase(
            name = "", email = "", passWord = ""
        )
        assertThat(result).isEqualTo(LoginAuthenticationType.EmptyField)
    }
    @Test
    fun `test login email input return invalid email`() {
        val result = loginAuthenticationUseCase(
            name = "John Deo", email = "JohnDeo", passWord = "SignUp/Login"
        )
        assertThat(result).isEqualTo(LoginAuthenticationType.InvalidEmail)
    }
}