package com.example.consecutivepractices.repository

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieDatabaseEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}