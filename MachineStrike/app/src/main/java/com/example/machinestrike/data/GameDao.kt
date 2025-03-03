package com.example.machinestrike.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @Query("SELECT * FROM game")
    fun getAll(): Flow<List<Game>>

    @Insert
    suspend fun insert(game: Game)

    @Delete
    suspend fun delete(game: Game)

    @Update
    suspend fun update(game: Game)
}