package com.example.android_project.ui.room

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.exampl.android_project.ui.room.RoomDetailActivity
import com.example.android_project.R
import com.example.android_project.model.Room

class RoomListActivity : AppCompatActivity() {

    private lateinit var rvRoomList: RecyclerView
    private lateinit var roomAdapter: RoomAdapter
    private lateinit var btnCreateRoom: Button
    private lateinit var btnJoinRoom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_list)

        rvRoomList = findViewById(R.id.rvRoomList)
        btnCreateRoom = findViewById(R.id.btnCreateRoom)
        btnJoinRoom = findViewById(R.id.btnJoinRoom)

        // 임시 방 데이터
        val roomList = mutableListOf(
            Room(
                roomId = 1,
                roomName = "우리 집",
                roomCode = "ABC123",
                createdAt = "2026-11-25",
                memberCount = 3,
                isOwner = true
            ),
            Room(
                roomId = 2,
                roomName = "자취방",
                roomCode = "DEF456",
                createdAt = "2026-11-25",
                memberCount = 2,
                isOwner = false
            )
        )

        // RecyclerView 설정
        roomAdapter = RoomAdapter(roomList) { room ->
            val intent = Intent(
                this,
                RoomDetailActivity::class.java
            )

            intent.putExtra("roomId", room.roomId)
            intent.putExtra("roomName", room.roomName)
            intent.putExtra("roomCode", room.roomCode)
            intent.putExtra("isOwner", room.isOwner)
            intent.putExtra("memberCount", room.memberCount)

            startActivity(intent)
        }

        rvRoomList.adapter = roomAdapter
        rvRoomList.layoutManager = LinearLayoutManager(this)

        // 방 만들기 화면 이동
        btnCreateRoom.setOnClickListener {
            val intent = Intent(this, RoomCreateActivity::class.java)
            startActivity(intent)
        }

        // 방 참여 화면 이동
        btnJoinRoom.setOnClickListener {
            val intent = Intent(this, RoomJoinActivity::class.java)
            startActivity(intent)
        }
    }
}
