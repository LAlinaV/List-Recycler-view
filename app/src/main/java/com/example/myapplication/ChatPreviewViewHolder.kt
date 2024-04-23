package com.example.myapplication

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class ChatPreviewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val userPhoto: ImageView = itemView.findViewById(R.id.user_photo)
    private val userName: TextView = itemView.findViewById(R.id.user_name)
    private val lastMessage: TextView = itemView.findViewById(R.id.last_message)

    fun onBind(chatPreview: ChatPreview){
        userPhoto.setImageDrawable(chatPreview.userPhoto)
        userName.text=chatPreview.userName
        lastMessage.text = chatPreview.lastMessage
    }
}