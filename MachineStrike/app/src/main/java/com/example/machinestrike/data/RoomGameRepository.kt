package com.example.machinestrike.data

import kotlinx.coroutines.flow.Flow

class RoomGameRepository(private val gameDao: GameDao) : GameRepository {
    override val gameStream: Flow<List<Game>> = gameDao.getAll()
    override suspend fun addGame(game: Game) = gameDao.insert(game)
    override suspend fun deleteGame(game: Game) = gameDao.delete(game)
    override suspend fun updateGame(game: Game) = gameDao.update(game)
}