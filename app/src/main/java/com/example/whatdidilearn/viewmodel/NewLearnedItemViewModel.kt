package com.example.whatdidilearn.viewmodel

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatdidilearn.entities.ItemLearned
import com.example.whatdidilearn.entities.Level
import com.example.whatdidilearn.repository.LearnedItemRepository
import com.example.whatdidilearn.view.NewLearnedItem
import kotlinx.coroutines.launch

class NewLearnedItemViewModel(private val repository: LearnedItemRepository): ViewModel() {
    var valid: Boolean = true

    fun insertNewLearnedItem(itemTitle: String, itemDescription: String) {
        if (itemTitle != null && !itemTitle.trim().isEmpty() && itemDescription != null && !itemDescription.trim().isEmpty()) {
            viewModelScope.launch {
                val item = ItemLearned(itemTitle, itemDescription, Level.HIGH)
                repository.insertNewLearnedItem(item)
            }
        } else {

        }
    }
}


