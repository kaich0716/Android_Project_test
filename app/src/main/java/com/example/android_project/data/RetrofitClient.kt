package com.example.android_project.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://10.0.2.2:3000/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 로그인 및 회원가입 API
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    // 방 관리 API
    val roomApiService: RoomApiService by lazy {
        retrofit.create(RoomApiService::class.java)
    }
}
