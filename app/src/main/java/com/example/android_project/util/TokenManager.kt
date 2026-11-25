package com.example.android_project.util

import android.content.Context

class TokenManager(context: Context) {

    // 토큰을 저장할 공간
    private val preferences = context.getSharedPreferences(
        "roomade_token",
        Context.MODE_PRIVATE
    )

    // 토큰 저장
    fun saveToken(token: String) {
        preferences.edit()
            .putString("access_token", token)
            .apply()
    }

    // 저장된 토큰 가져오기
    fun getToken(): String? {
        return preferences.getString("access_token", null)
    }

    // 토큰 삭제 (로그아웃)
    fun clearToken() {
        preferences.edit()
            .remove("access_token")
            .apply()
    }
}
