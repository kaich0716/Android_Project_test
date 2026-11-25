package com.example.android_project.model

data class SignupRequest(
    val loginId: String,
    val password: String,
    val name: String,
    val nickname: String,
    val phone: String,
    val accountInfo: String,
    val birthDate: String,
    val gender: String
)
