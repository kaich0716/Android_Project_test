package com.example.android_project.data
import com.example.android_project.util.TokenManager

import android.content.Context
import com.example.android_project.model.RoomRequest

import com.google.gson.JsonObject
import retrofit2.Response

class RoomRepository(context: Context) {

    // JWT 토큰 관리 객체
    private val tokenManager = TokenManager(context)

    // 방 관리 API 객체
    private val apiService = RetrofitClient.roomApiService

    // 토큰 가져오기
    private fun getAuthToken(): String? {
        val token = tokenManager.getToken()

        return token?.let {
            "Bearer $it"
        }
    }

    // 1. 방 생성
    suspend fun createRoom(
        roomName: String
    ): Response<JsonObject>? {

        val token = getAuthToken() ?: return null

        val request = RoomRequest.CreateRoomRequest(roomName)

        return apiService.createRoom(token, request)
    }

    // 2. 방 참여
    suspend fun joinRoom(
        roomCode: String
    ): Response<JsonObject>? {

        val token = getAuthToken() ?: return null

        val request = RoomRequest.JoinRoomRequest(roomCode)

        return apiService.joinRoom(token, request)
    }

    // 3. 내가 참여한 방 목록 조회
    suspend fun getMyRooms(): Response<JsonObject>? {

        val token = getAuthToken() ?: return null

        return apiService.getMyRooms(token)
    }

    // 4. 방 상세 정보 조회
    suspend fun getRoomDetail(
        roomId: Int
    ): Response<JsonObject>? {

        val token = getAuthToken() ?: return null

        return apiService.getRoomDetail(token, roomId)
    }

    // 5. 방 나가기
    suspend fun leaveRoom(
        roomId: Int
    ): Response<JsonObject>? {

        val token = getAuthToken() ?: return null

        return apiService.leaveRoom(token, roomId)
    }

    // 6. 방 삭제
    suspend fun deleteRoom(
        roomId: Int
    ): Response<JsonObject>? {

        val token = getAuthToken() ?: return null

        return apiService.deleteRoom(token, roomId)
    }
}
