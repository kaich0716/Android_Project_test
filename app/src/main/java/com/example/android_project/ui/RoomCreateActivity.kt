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

class RoomCreateActivity : AppCompatActivity() {

    private lateinit var roomRepository: RoomRepository

    private lateinit var etRoomName: EditText
    private lateinit var btnCreateRoom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_create)

        // Repository 객체 생성
        roomRepository = RoomRepository(this)

        // 화면 요소 연결
        etRoomName = findViewById(R.id.etRoomName)
        btnCreateRoom = findViewById(R.id.btnCreateRoom)

        // 방 생성 버튼 클릭
        btnCreateRoom.setOnClickListener {
            createRoom()
        }
    }

    // 방 생성
    private fun createRoom() {

        // 입력한 방 이름 가져오기
        val roomName = etRoomName.text.toString().trim()

        // 입력값 검사
        if (roomName.isEmpty()) {
            etRoomName.error = "방 이름을 입력해 주세요."
            return
        }

        // 버튼 중복 클릭 방지
        btnCreateRoom.isEnabled = false

        lifecycleScope.launch {

            try {

                // 서버에 방 생성 요청
                val response = roomRepository.createRoom(roomName)

                if (response == null) {

                    Toast.makeText(
                        this@RoomCreateActivity,
                        "로그인이 필요합니다.",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@launch
                }

                if (response.isSuccessful) {

                    Toast.makeText(
                        this@RoomCreateActivity,
                        "방이 생성되었습니다.",
                        Toast.LENGTH_SHORT
                    ).show()

                    // 방 목록 화면으로 돌아가기
                    finish()

                } else {

                    Toast.makeText(
                        this@RoomCreateActivity,
                        "방 생성 실패: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } catch (e: Exception) {

                Toast.makeText(
                    this@RoomCreateActivity,
                    "오류 발생: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()

            } finally {

                // 버튼 다시 활성화
                btnCreateRoom.isEnabled = true
            }
        }
    }
}
