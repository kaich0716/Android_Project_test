package com.example.android_project.model

class RoomRequest {
    // 방 생성 요청
    data class CreateRoomRequest(
        val roomName: String
    )
    // 방 참여 요청
    data class JoinRoomRequest(
        val roomCode: String
    )
}