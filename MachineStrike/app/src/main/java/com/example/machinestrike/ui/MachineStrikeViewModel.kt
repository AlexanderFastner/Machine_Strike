package com.example.machinestrike.ui

import androidx.lifecycle.ViewModel
import com.example.machinestrike.data.GameRepository
import com.example.machinestrike.data.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//class MachineStrikeViewModel (val gameRepository: GameRepository): ViewModel() {
class MachineStrikeViewModel (): ViewModel() {

    //uiState
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun setGamemode(gameMode: String) {
        _uiState.update { currentState ->
            currentState.copy(
                gameType = gameMode
            )
        }
    }

    fun setDifficulty(difficultyLevel: String) {
        _uiState.update { currentState ->
            currentState.copy(
                difficulty = difficultyLevel
            )
        }
    }

    fun setBoard(selectedBoard: String){

        //TODO have this function take in a string and set the actual board off of that?
        _uiState.update { currentState ->
            currentState.copy(
                board = selectedBoard
            )
        }

    }




}