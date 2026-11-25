package com.example.android_project.data

import com.example.android_project.model.RoomRequest
import com.google.gson.JsonObject

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface RoomApiService {

    // 방 생성
    @POST("api/rooms")
    suspend fun createRoom(
        @Header("Authorization") token: String,
        @Body request: RoomRequest.CreateRoomRequest
    ): Response<JsonObject>

    // 방 참여
    @POST("api/rooms/join")
    suspend fun joinRoom(
        @Header("Authorization") token: String,
        @Body request: RoomRequest.JoinRoomRequest
    ): Response<JsonObject>

    // 내가 참여한 방 목록 조회
    @GET("api/rooms/my")
    suspend fun getMyRooms(
        @Header("Authorization") token: String
    ): Response<JsonObject>

    // 방 상세 정보 조회
    @GET("api/rooms/{roomId}")
    suspend fun getRoomDetail(
        @Header("Authorization") token: String,
        @Path("roomId") roomId: Int
    ): Response<JsonObject>

    // 방 나가기
    @POST("api/rooms/{roomId}/leave")
    suspend fun leaveRoom(
        @Header("Authorization") token: String,
        @Path("roomId") roomId: Int
    ): Response<JsonObject>

    // 방 삭제
    @DELETE("api/rooms/{roomId}")
    suspend fun deleteRoom(
        @Header("Authorization") token: String,
        @Path("roomId") roomId: Int
    ): Response<JsonObject>
}
