package com.example.android_project.ui.room

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.R
import com.example.android_project.model.RoomMember

class RoomDetailActivity : AppCompatActivity() {

    private lateinit var tvRoomName: TextView
    private lateinit var tvRoomCode: TextView
    private lateinit var tvRoomRole: TextView
    private lateinit var tvRoomMemberCount: TextView

    private lateinit var rvRoomMembers: RecyclerView

    private lateinit var btnLeaveRoom: Button
    private lateinit var btnDeleteRoom: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_detail)

        // 화면 요소 연결
        tvRoomName = findViewById(R.id.tvDetailRoomName)
        tvRoomCode = findViewById(R.id.tvDetailRoomCode)
        tvRoomRole = findViewById(R.id.tvDetailRoomRole)
        tvRoomMemberCount = findViewById(R.id.tvDetailMemberCount)

        rvRoomMembers = findViewById(R.id.rvRoomMembers)

        btnLeaveRoom = findViewById(R.id.btnLeaveRoom)
        btnDeleteRoom = findViewById(R.id.btnDeleteRoom)
        btnBack = findViewById(R.id.btnDetailBack)

        // 이전 화면에서 전달받은 방 정보
        val roomName =
            intent.getStringExtra("roomName") ?: "방 이름 없음"

        val roomCode =
            intent.getStringExtra("roomCode") ?: "-"

        val isOwner =
            intent.getBooleanExtra("isOwner", false)

        val memberCount =
            intent.getIntExtra("memberCount", 0)

        // 방 정보 표시
        tvRoomName.text = roomName
        tvRoomCode.text = "방 참여 코드: $roomCode"

        tvRoomRole.text =
            if (isOwner) "방장" else "일반 멤버"

        tvRoomMemberCount.text =
            "참여 인원: ${memberCount}명"

        // 임시 회원 데이터
        val memberList = listOf(
            RoomMember(
                memberId = 1,
                nickname = "창민",
                isOwner = true,
                joinedAt = "2026-11-20"
            ),
            RoomMember(
                memberId = 2,
                nickname = "민수",
                isOwner = false,
                joinedAt = "2026-11-21"
            ),
            RoomMember(
                memberId = 3,
                nickname = "지우",
                isOwner = false,
                joinedAt = "2026-11-22"
            )
        )

        // 회원 목록 표시
        val memberAdapter = RoomMemberAdapter(memberList)

        rvRoomMembers.layoutManager =
            LinearLayoutManager(this)

        rvRoomMembers.adapter = memberAdapter

        // 사용자 역할에 따른 버튼 표시
        if (isOwner) {
            btnDeleteRoom.visibility = Button.VISIBLE
            btnLeaveRoom.visibility = Button.GONE
        } else {
            btnLeaveRoom.visibility = Button.VISIBLE
            btnDeleteRoom.visibility = Button.GONE
        }

        // 방 삭제 버튼
        btnDeleteRoom.setOnClickListener {
            showDeleteDialog()
        }

        // 방 나가기 버튼
        btnLeaveRoom.setOnClickListener {
            showLeaveDialog()
        }

        // 뒤로 가기
        btnBack.setOnClickListener {
            finish()
        }
    }

    // 방 삭제 확인 창
    private fun showDeleteDialog() {
        AlertDialog.Builder(this)
            .setTitle("방 삭제")
            .setMessage(
                "정말 방을 삭제하시겠습니까?\n" +
                        "실제 방 삭제는 서버 연결 후 처리됩니다."
            )
            .setPositiveButton("확인") { _, _ ->
                Toast.makeText(
                    this,
                    "현재는 화면 테스트 단계입니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("취소", null)
            .show()
    }

    // 방 나가기 확인 창
    private fun showLeaveDialog() {
        AlertDialog.Builder(this)
            .setTitle("방 나가기")
            .setMessage(
                "정말 이 방에서 나가시겠습니까?\n" +
                        "실제 탈퇴 처리는 서버 연결 후 진행됩니다."
            )
            .setPositiveButton("확인") { _, _ ->
                Toast.makeText(
                    this,
                    "현재는 화면 테스트 단계입니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("취소", null)
            .show()
    }
}
