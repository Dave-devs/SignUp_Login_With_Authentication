package com.dave_devs.signupandloginwithfirebaseauthentication.domain.core

import com.dave_devs.signupandloginwithfirebaseauthentication.core.containNumber
import com.dave_devs.signupandloginwithfirebaseauthentication.core.containSpecialChar
import com.dave_devs.signupandloginwithfirebaseauthentication.core.containUpperCase
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class StringExtensionTest {

    @Test
    fun `test string contain number return false`() {
        val result = "DoNotContainNumber".containNumber()
        assertThat(result).isFalse()
    }
    @Test
    fun `test string contain number return true`() {
        val result = "DoContainNumber1".containNumber()
        assertThat(result).isTrue()
    }
    @Test
    fun `test string contain upper case character return false`() {
        val result = "nouppercasecharacter".containUpperCase()
        assertThat(result).isFalse()
    }
    @Test
    fun `test string contain upper case character return true`() {
        val result = "UpperCaseCharacter".containUpperCase()
        assertThat(result).isTrue()
    }
    @Test
    fun `test string contain special character return false`() {
        val result = "NoSpecialChar".containSpecialChar()
        assertThat(result).isFalse()
    }
    @Test
    fun `test string contain special character return true`() {
        val result = "NoSpecialChar*/".containSpecialChar()
        assertThat(result).isTrue()
    }
}