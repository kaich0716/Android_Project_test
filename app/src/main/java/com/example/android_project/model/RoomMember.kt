package com.example.android_project.model

data class RoomMember(
    val memberId: Int,
    val nickname: String,
    val isOwner: Boolean,
    val joinedAt: String
)
