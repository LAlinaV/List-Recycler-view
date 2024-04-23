package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoChatViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    private val videoChatName: TextView = itemView.findViewById(R.id.video_chat_name)
    private val numberOfParticipants: TextView = itemView.findViewById(R.id.number_of_participants)

    fun onBind(videoChat:VideoChat){
        videoChatName.text = videoChat.videoChatName
        numberOfParticipants.text = "People:${videoChat.numberOfParticipants}"
    }
}