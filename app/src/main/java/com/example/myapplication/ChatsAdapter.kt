package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

public final class ChatsAdapter: RecyclerView.Adapter<ViewHolder>() {
    var chats = listOf<Chat>()
        set(value){
            val callback = CommonCallbackImpl(
                oldItems = field,
                newItems = value,
                {oldItem: Chat, newItem-> oldItem.id == newItem.id}
            )
            field = value
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
        }

    override fun getItemViewType(position: Int): Int {
        return when(chats[position]){
            is ChatPreview -> CHAT_PREVIEW_TYPE
            is VideoChat -> VIDEOCHAT_TYPE
        }
    }

    companion object{
        private const val CHAT_PREVIEW_TYPE = 0
        private const val VIDEOCHAT_TYPE = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
            CHAT_PREVIEW_TYPE ->ChatPreviewViewHolder(
            layoutInflater.inflate(
                R.layout.chat_preview,
                parent,
                false
            )
        )
            VIDEOCHAT_TYPE -> VideoChatViewHolder(
                layoutInflater.inflate(
                    R.layout.video_chat,
                    parent,
                    false
                )
            )
            else -> throw java.lang.IllegalArgumentException("viewType is invalid")
        }
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is ChatPreviewViewHolder -> holder.onBind(chats[position] as ChatPreview)
            is VideoChatViewHolder -> holder.onBind(chats[position] as VideoChat)
        }

    }
}