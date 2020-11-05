package com.example.whatdidilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatdidilearn.R
import com.example.whatdidilearn.data.DatabaseItems
import com.example.whatdidilearn.databinding.ActivityMainBinding
import com.example.whatdidilearn.databinding.ActivityNewLearnedItemBinding


class NewLearnedItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewLearnedItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title ="New Learned Item"

    }
}

