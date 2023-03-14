package com.dave_devs.signupandloginwithfirebaseauthentication.core

fun String.containNumber(): Boolean {
    val regex = Regex(".*\\d+.*")
    return regex.matches(this)
}

fun String.containUpperCase(): Boolean {
    val regex = Regex(".*[A-Z]+.*")
    return regex.matches(this)
}

fun String.containSpecialChar(): Boolean {
    val regex = Regex(".*[^A-Za-z\\d]+.*")
    return regex.matches(this)
}