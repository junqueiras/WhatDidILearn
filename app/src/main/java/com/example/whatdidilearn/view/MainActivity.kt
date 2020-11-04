package com.example.whatdidilearn.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.whatdidilearn.R
import com.example.whatdidilearn.data.DatabaseItems
import com.example.whatdidilearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonNextActivity = binding.buttonNextActivity
        buttonNextActivity.setOnClickListener {
            var intent = Intent(this,NewLearnedItem::class.java)
            startActivity(intent)
        }

        

        val recyclerView = binding.itemsRecycleView
        val adapter = LearnedItemsAdapter()
        recyclerView.adapter = adapter

        val learnedItemsList = DatabaseItems.getAll()
        adapter.data = learnedItemsList
    }
}