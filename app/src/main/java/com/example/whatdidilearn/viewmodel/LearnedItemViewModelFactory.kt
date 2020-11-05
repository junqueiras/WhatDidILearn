package com.example.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatdidilearn.data.ItemLearnedDao

class LearnedItemViewModelFactory (private val dao: ItemLearnedDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LearnedItemViewModel::class.java)) {
            return LearnedItemViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}