package com.melany.lab06_spotify.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melany.lab06_spotify.MusicRepository
import com.melany.lab06_spotify.adapter.ListAdapter
import com.melany.lab06_spotify.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var contactListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        contactListRecyclerView = binding.contactsList
        contactListRecyclerView.layoutManager = LinearLayoutManager(this)
        val music = MusicRepository()
        val contactsAdapter = ListAdapter(music.music)
        contactListRecyclerView.adapter = contactsAdapter
    }
}
