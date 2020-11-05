package com.example.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.whatdidilearn.data.ItemLearnedDao
import com.example.whatdidilearn.entities.ItemLearned

class LearnedItemViewModel(private val dao: ItemLearnedDao): ViewModel(){
    val learnedItemsList: LiveData<List<ItemLearned>>

    init{
        learnedItemsList = dao.getAll()
    }
}