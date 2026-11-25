package com.example.android_project.model

data class LoginRequest(
    val loginId: String,
    val password: String,
    val keepLogin: Boolean
)
