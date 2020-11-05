package com.example.whatdidilearn.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.whatdidilearn.entities.ItemLearned

@Dao
interface ItemLearnedDao {
    @Query("SELECT * FROM learned_item ORDER BY item_title ASC")
    fun getAll(): LiveData<List<ItemLearned>>

    @Insert
    suspend fun insert(item: ItemLearned)
}