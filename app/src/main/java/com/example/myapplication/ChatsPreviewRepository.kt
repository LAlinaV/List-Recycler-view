package com.example.myapplication

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources

class ChatsPreviewRepository {
    fun getChats(context: Context):List<ChatPreview>{
        return buildList {
            val userPhoto = AppCompatResources.getDrawable(context, R.drawable.default_photo)
            val userName = "Alina Ladik"
            val lastMessage = "Hi, how are you?"

            val numberOfChats=(1..10).random()
            for(i in 0..numberOfChats)
                add(ChatPreview(i,userPhoto, userName, lastMessage))

        }

    }
}