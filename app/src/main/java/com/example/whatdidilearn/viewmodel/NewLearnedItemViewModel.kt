package com.example.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatdidilearn.data.ItemLearnedDao
import com.example.whatdidilearn.entities.ItemLearned
import com.example.whatdidilearn.entities.Level
import com.example.whatdidilearn.repository.LearnedItemRepository
import kotlinx.coroutines.launch

class NewLearnedItemViewModel(private val repository: LearnedItemRepository): ViewModel() {

    fun insertNewLearnedItem(itemTitle: String, itemDescription: String) {
        viewModelScope.launch {
            val item = ItemLearned(itemTitle, itemDescription, Level.HIGH)
            repository.insertNewLearnedItem(item)
        }
    }
}