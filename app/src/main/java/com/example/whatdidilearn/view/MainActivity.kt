package com.example.whatdidilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.whatdidilearn.R
import com.example.whatdidilearn.data.DatabaseItems

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.items_recycle_view)
        val adapter = LearnedItemsAdapter()
        recyclerView.adapter = adapter

        val learnedItemsList = DatabaseItems().getAll()
        adapter.data = learnedItemsList
    }
}