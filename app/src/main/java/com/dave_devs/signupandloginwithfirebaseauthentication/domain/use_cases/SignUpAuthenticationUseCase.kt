package com.dave_devs.signupandloginwithfirebaseauthentication.domain.use_cases

import com.dave_devs.signupandloginwithfirebaseauthentication.domain.SignUpAuthenticationType
import com.dave_devs.signupandloginwithfirebaseauthentication.core.containSpecialChar
import com.dave_devs.signupandloginwithfirebaseauthentication.core.containUpperCase

class SignUpAuthenticationUseCase {

    operator fun invoke(
        name: String,
        email: String,
        passWord: String,
        repeatedPassWord: String
    ): SignUpAuthenticationType {
        if(name.isEmpty() || email.isEmpty() || passWord.isEmpty() || repeatedPassWord.isEmpty()) {
            return SignUpAuthenticationType.EmptyField
        }
        if("@gmail.com" !in email) {
            return SignUpAuthenticationType.InvalidEmail
        }
        if(passWord != repeatedPassWord) {
            return SignUpAuthenticationType.PasswordDoNotMatch
        }
        if(passWord.count() < 10) {
            return SignUpAuthenticationType.PasswordTooSort
        }
        if(!passWord.containUpperCase()) {
            return SignUpAuthenticationType.PasswordUpperCaseMissing
        }
        if(!passWord.containSpecialChar()) {
            return SignUpAuthenticationType.PasswordSpecialCharMissing
        }
        return SignUpAuthenticationType.Valid
    }
}