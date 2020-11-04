package com.example.whatdidilearn.data

import androidx.room.TypeConverter
import com.example.whatdidilearn.R
import com.example.whatdidilearn.entities.Level

class Converters {
    @TypeConverter
    fun levelToInt(level: Level): Int {
        return level.color
    }

    @TypeConverter
    fun intToLevel(color: Int): Level {
        return when(color){
            R.color.purple_200 -> Level.LOW
            R.color.purple_500 -> Level.MEDIUM
            else -> Level.HIGH
        }
    }
}