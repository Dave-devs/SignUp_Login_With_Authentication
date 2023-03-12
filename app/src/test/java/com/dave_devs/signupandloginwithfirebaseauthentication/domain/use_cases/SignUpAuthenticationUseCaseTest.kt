package com.dave_devs.signupandloginwithfirebaseauthentication.domain.use_cases

import com.dave_devs.signupandloginwithfirebaseauthentication.domain.SignUpAuthenticationType
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class SignUpAuthenticationUseCaseTest {

    private val signUpAuthenticationUseCase = SignUpAuthenticationUseCase()


    @Test
    fun `test signup inputs are correct return valid`() {
        val result = signUpAuthenticationUseCase(
            name = "John Deo", email = "Johndeo@gmail.com", passWord = "SignUp/Login", repeatedPassWord = "SignUp/Login"
        )
        assertThat(result).isEqualTo(SignUpAuthenticationType.Valid)
    }
    @Test
    fun `test signup inputs are correct return empty field`() {
        val result = signUpAuthenticationUseCase(
            name = "John Deo", email = "Johndeo@gmail", passWord = "SignLogin", repeatedPassWord = ""
        )
        assertThat(result).isEqualTo(SignUpAuthenticationType.EmptyField)
    }
    @Test
    fun `test signup input with valid email return no email` () {
        val result = signUpAuthenticationUseCase(
            name = "John Deo", email = "john deo", passWord = "SignUp/Login", repeatedPassWord = "SignUp/Login"
        )
        assertThat(result).isEqualTo(SignUpAuthenticationType.InvalidEmail)
    }
    @Test
    fun `test signup input with valid repeated password return password don't match`() {
        val result = signUpAuthenticationUseCase(
            name = "John Deo", email = "JohnDeo@gmail.com", passWord = "SignUp/Login", repeatedPassWord = "SignLogin"
        )
        assertThat(result).isEqualTo(SignUpAuthenticationType.PasswordDoNotMatch)
    }
    @Test
    fun `test signup input password upper case character return password upper case missing`() {
        val result = signUpAuthenticationUseCase(
            name = "John Deo", email = "JohnDeo@gmail.com", passWord = "signuplogin", repeatedPassWord = "signuplogin"
        )
        assertThat(result).isEqualTo(SignUpAuthenticationType.PasswordUpperCaseMissing)
    }
    @Test
    fun `test signup input password special char missing return password special case missing`() {
        val result = signUpAuthenticationUseCase(
            name = "John Deo", email = "JohnDeo@gmail.com", passWord = "SignUpLogin", repeatedPassWord = "SignUpLogin"
        )
        assertThat(result).isEqualTo(SignUpAuthenticationType.PasswordSpecialCharMissing)
    }
    @Test
    fun `test signup input password count less than ten return password count less than ten`() {
        val result = signUpAuthenticationUseCase(
            name = "John Deo", email = "JohnDeo@gmail.com", passWord = "SignUp", repeatedPassWord = "SignUp"
        )
        assertThat(result).isEqualTo(SignUpAuthenticationType.PasswordTooSort)
    }
}