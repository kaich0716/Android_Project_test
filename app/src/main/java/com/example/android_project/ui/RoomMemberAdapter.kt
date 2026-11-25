package com.example.android_project.ui.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.R
import com.example.android_project.model.RoomMember

class RoomMemberAdapter(
    private val memberList: List<RoomMember>
) : RecyclerView.Adapter<RoomMemberAdapter.MemberViewHolder>() {

    class MemberViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val tvMemberNickname: TextView =
            itemView.findViewById(R.id.tvMemberNickname)

        val tvMemberJoinedAt: TextView =
            itemView.findViewById(R.id.tvMemberJoinedAt)

        val tvMemberRole: TextView =
            itemView.findViewById(R.id.tvMemberRole)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemberViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_room_member, parent, false)

        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MemberViewHolder,
        position: Int
    ) {
        val member = memberList[position]

        holder.tvMemberNickname.text = member.nickname

        holder.tvMemberJoinedAt.text =
            "가입일: ${member.joinedAt}"

        holder.tvMemberRole.text =
            if (member.isOwner) "방장" else "일반 멤버"
    }

    override fun getItemCount(): Int {
        return memberList.size
    }
}
