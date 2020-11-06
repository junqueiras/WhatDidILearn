package com.example.whatdidilearn.repository

import com.example.whatdidilearn.data.ItemLearnedDao
import com.example.whatdidilearn.entities.ItemLearned

class LearnedItemRepository(private val dao: ItemLearnedDao) {
    val learnedItems = dao.getAll()

    suspend fun insertNewLearnedItem(item: ItemLearned){
        dao.insert(item)
    }
}