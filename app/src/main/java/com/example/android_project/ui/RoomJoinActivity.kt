package com.example.android_project.ui.room

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.android_project.R
import com.example.android_project.data.RoomRepository
import kotlinx.coroutines.launch

class RoomJoinActivity : AppCompatActivity() {

    private lateinit var roomRepository: RoomRepository
    private lateinit var etRoomCode: EditText
    private lateinit var btnJoinRoom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_join)

        roomRepository = RoomRepository(this)

        etRoomCode = findViewById(R.id.etRoomCode)
        btnJoinRoom = findViewById(R.id.btnJoinRoom)

        btnJoinRoom.setOnClickListener {
            joinRoom()
        }
    }

    private fun joinRoom() {
        val roomCode = etRoomCode.text.toString().trim()

        if (roomCode.isEmpty()) {
            etRoomCode.error = "방 참여 코드를 입력해 주세요."
            return
        }

        btnJoinRoom.isEnabled = false

        lifecycleScope.launch {
            try {
                val response = roomRepository.joinRoom(roomCode)

                if (response == null) {
                    Toast.makeText(
                        this@RoomJoinActivity,
                        "로그인이 필요합니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@launch
                }

                if (response.isSuccessful) {
                    Toast.makeText(
                        this@RoomJoinActivity,
                        "방에 참여했습니다.",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()

                } else {
                    Toast.makeText(
                        this@RoomJoinActivity,
                        "방 참여 실패: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } catch (e: Exception) {
                Toast.makeText(
                    this@RoomJoinActivity,
                    "오류 발생: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()

            } finally {
                btnJoinRoom.isEnabled = true
            }
        }
    }
}
