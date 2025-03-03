package com.example.machinestrike.data

import android.content.Context

class AppDataContainer(private val context: Context) : AppContainer {
    override val gameRepository: GameRepository by lazy {
        RoomGameRepository(AppDatabase.getDatabase(context).gameDao())
    }
}
