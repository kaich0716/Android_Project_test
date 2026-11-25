package com.example.android_project.data

import com.example.android_project.model.SignupRequest
import com.example.android_project.model.LoginRequest

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    // 회원가입
    @POST("api/auth/signup")
    suspend fun signup(
        @Body request: SignupRequest
    ): Response<JsonObject>


    // 로그인
    @POST("api/auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<JsonObject>


    // 아이디 중복 확인
    @GET("api/auth/check-login-id")
    suspend fun checkLoginId(
        @Query("loginId") loginId: String
    ): Response<JsonObject>


    // 닉네임 중복 확인
    @GET("api/auth/check-nickname")
    suspend fun checkNickname(
        @Query("nickname") nickname: String
    ): Response<JsonObject>

}
