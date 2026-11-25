package com.example.android_project.ui.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.R
import com.example.android_project.model.Room

class RoomAdapter(
    private val roomList: MutableList<Room>,
    private val onRoomClick: (Room) -> Unit
) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    class RoomViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val tvRoomName: TextView =
            itemView.findViewById(R.id.tvRoomName)

        val tvRoomRole: TextView =
            itemView.findViewById(R.id.tvRoomRole)

        val tvRoomMemberCount: TextView =
            itemView.findViewById(R.id.tvRoomMemberCount)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RoomViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_room, parent, false)

        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RoomViewHolder,
        position: Int
    ) {
        val room = roomList[position]

        holder.tvRoomName.text = room.roomName

        holder.tvRoomRole.text =
            if (room.isOwner) "방장" else "일반 멤버"

        holder.tvRoomMemberCount.text =
            "참여 인원 ${room.memberCount}명"

        // 방 카드를 클릭하면 상세 화면으로 이동
        holder.itemView.setOnClickListener {
            onRoomClick(room)
        }
    }

    override fun getItemCount(): Int {
        return roomList.size
    }

    fun updateRooms(newRooms: List<Room>) {
        roomList.clear()
        roomList.addAll(newRooms)
        notifyDataSetChanged()
    }
}
