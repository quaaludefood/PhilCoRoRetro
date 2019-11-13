package com.example.philcororetro.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.philcororetro.model.Action

@Dao
interface ActionDao {

    @Insert
    fun insertActions(actions: List<Action>): List<Long>

    /**
     * Get all the articles from table
     */
    @Query("SELECT * FROM actions")
    suspend fun getActions(): List<Action>
}
