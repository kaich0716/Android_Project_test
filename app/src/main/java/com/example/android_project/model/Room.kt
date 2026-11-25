package com.example.android_project.model

data class Room(
    val roomId: Int,
    val roomName: String,
    val roomCode: String,
    val createdAt: String,
    val memberCount: Int,
    val isOwner: Boolean
)