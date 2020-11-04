package com.example.whatdidilearn.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "learned_item")
data class ItemLearned (
    @ColumnInfo(name = "item_title")
    val title: String,

    @ColumnInfo(name = "item_description")
    val description: String,

    @ColumnInfo(name = "item_level")
    val understandingLevel: Level,

    @ColumnInfo(name = "item_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)