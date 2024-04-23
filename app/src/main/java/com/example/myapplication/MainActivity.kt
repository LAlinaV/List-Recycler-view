package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {
    private lateinit var chatsRecyclerView: RecyclerView
    private val chatsPreviewRepository=ChatsPreviewRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chatsRecyclerView = findViewById(R.id.chats)
        val chatsAdapter = ChatsAdapter()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        chatsRecyclerView.adapter = chatsAdapter
        chatsRecyclerView.layoutManager = layoutManager
        chatsAdapter.chats = chatsPreviewRepository.getChats(this)
        chatsRecyclerView.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        chatsRecyclerView.addItemDecoration(ChatPreviewOffsetItemDecoration(
            bottomOffset = 16f.toInt(),
            topOffset = 16f.toInt()
            ))
        val pullToRefresh:SwipeRefreshLayout = findViewById(R.id.pull_to_refresh)
        pullToRefresh.setOnRefreshListener {
            chatsAdapter.chats = chatsPreviewRepository.getChats(this)
            pullToRefresh.isRefreshing = false
        }

    }
}