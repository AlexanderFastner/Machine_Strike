package com.example.machinestrike.data

import com.example.machinestrike.data.GameBoard
import com.example.machinestrike.data.Pieces.Piece

data class GameUiState (

    val gameType: String = "",
    val difficulty: String = "",

    //TODO pass in gameboard somehow
    val board:  String = "",
    val pieces: List<Piece> = listOf(),
    //val pickupOptions: List<String> = listOf()
    )