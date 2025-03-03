package com.example.machinestrike.data

import kotlinx.coroutines.flow.Flow

interface GameRepository {
    val gameStream: Flow<List<Game>>
    suspend fun addGame(game: Game)
    suspend fun deleteGame(game: Game)
    suspend fun updateGame(game: Game)
}