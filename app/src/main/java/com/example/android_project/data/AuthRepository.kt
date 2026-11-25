package com.example.android_project.data

import com.example.android_project.model.SignupRequest
import com.example.android_project.model.LoginRequest
import com.google.gson.JsonObject
import retrofit2.Response

class AuthRepository {

    // Retrofit API 연결
    private val apiService = RetrofitClient.apiService

    // 회원가입
    suspend fun signup(
        request: SignupRequest
    ): Response<JsonObject> {
        return apiService.signup(request)
    }

    // 로그인
    suspend fun login(
        request: LoginRequest
    ): Response<JsonObject> {
        return apiService.login(request)
    }

    // 아이디 중복 확인
    suspend fun checkLoginId(
        loginId: String
    ): Response<JsonObject> {
        return apiService.checkLoginId(loginId)
    }

    // 닉네임 중복 확인
    suspend fun checkNickname(
        nickname: String
    ): Response<JsonObject> {
        return apiService.checkNickname(nickname)
    }
}
