package com.example.machinestrike.data

import com.example.machinestrike.data.GameBoard

data class GameUiState (

    val gameType: String = "",
    val difficulty: Int = 0,

    //TODO pass in gameboard somehow
//    val board: GameBoard,
    //TODO make piece class
//    val pieces: List<String> = listOf(),
    //val pickupOptions: List<String> = listOf()
    )