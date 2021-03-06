package com.example.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatdidilearn.data.ItemLearnedDao
import com.example.whatdidilearn.entities.ItemLearned
import com.example.whatdidilearn.repository.LearnedItemRepository
import kotlinx.coroutines.launch

class LearnedItemViewModel(private val repository: LearnedItemRepository): ViewModel() {
    val learnedItemsList: LiveData<List<ItemLearned>>

    init{
        learnedItemsList = repository.learnedItems
    }

    fun insertNewLearnedItem(item: ItemLearned) {
        viewModelScope.launch {
            repository.insertNewLearnedItem(item)
        }
    }
}