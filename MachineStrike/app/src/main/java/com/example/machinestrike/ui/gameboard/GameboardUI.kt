package com.example.machinestrike.ui.gameboard

//this is to visualize the board state

//8x8 board as default
//slider adjusts different sizes
//fog of war?
//can be different types
//an instance of it is created by selectboard
//default boards are saved as static objects
//need way to store presets? companion objects?



//TODO THIS NEEDS TO BE IN THE DATA LAYER, NOT THE UI
//need to add a repo layer


//This returns the selected boardUI
//given the data object/matrix logical part of board make a visual representation on the ui

open class GameboardUI(val type: String, val size: Int) {
    companion object Factory{
        fun create(type: String, size: Int): GameboardUI? {
            return when (type) {
                "Standard" -> StandardBoard(size)
                "Random" -> RandomBoard(size)
                else -> throw IllegalArgumentException("Invalid board type")
            }
        }
    }
    val board: Matrix8x8 = Matrix8x8()

}

class StandardBoard(size: Int) : GameboardUI("Standard", size) {
    init {
        // Initialize the standard board here
        board.fill(0)  // For example, fill with zeros
    }
}

class RandomBoard(size: Int) : GameboardUI("Random", size) {
    init {
        // Initialize the random board here
        for (i in 0..7) {
            for (j in 0..7) {
                board.set(i, j, (0..9).random())  // Fill with random numbers 0-9
            }
        }
    }
}


class Matrix8x8 {
    private val matrix: Array<IntArray> = Array(8) { IntArray(8) }

    fun set(row: Int, col: Int, value: Int) {
        if (row in 0..7 && col in 0..7) {
            matrix[row][col] = value
        } else {
            throw IndexOutOfBoundsException("Row and column must be between 0 and 7")
        }
    }

    fun get(row: Int, col: Int): Int {
        if (row in 0..7 && col in 0..7) {
            return matrix[row][col]
        } else {
            throw IndexOutOfBoundsException("Row and column must be between 0 and 7")
        }
    }

    fun fill(value: Int) {
        for (i in 0..7) {
            for (j in 0..7) {
                matrix[i][j] = value
            }
        }
    }

    override fun toString(): String {
        return matrix.joinToString("\n") { row ->
            row.joinToString(" ", "[", "]")
        }
    }
}