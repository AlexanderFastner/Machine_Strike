package com.example.machinestrike.ui.collection

import android.util.Log
import com.example.machinestrike.data.Pieces.Burrower
import com.example.machinestrike.data.Pieces.Piece
import com.example.machinestrike.data.Pieces.Scrapper


//TODO MAKE A CLASS WITH VARIABLES FOR EACH CLASS (INTS) default = 0
//TODO DISPLAY THAT LIST ITEMS, if number = 0 then disable




//val userPieces: MutableList<Piece> = mutableListOf()

class UserCollection{
    //All
    var allPieces: MutableList<Pair<Piece, Int>> = mutableListOf()
    var dashPieces: MutableList<Pair<Piece, Int>> = mutableListOf()
    var gunnerPieces: MutableList<Pair<Piece, Int>> = mutableListOf()
    var meleePieces: MutableList<Pair<Piece, Int>> = mutableListOf()
    var pullPieces: MutableList<Pair<Piece, Int>> = mutableListOf()
    var ramPieces: MutableList<Pair<Piece, Int>> = mutableListOf()
    var swoopPieces: MutableList<Pair<Piece, Int>> = mutableListOf()

    // TODO: THIS NEEDS TO BE STORED IN PREFERENCES or DATABASE!!
    //TODO THEN UPDATE WHAT THE USERS COLLECTION IS ON STARTUP OR UNLOCKING OF NEW PIECE
    fun loadAllUserPieces() {
        //Fill each list

        //all declarations
        val burrower = Burrower()
        val scrapper = Scrapper()


        //All
        allPieces.add(Pair(burrower, 2))
        allPieces.add(Pair(scrapper, 2))

        //DASH

        //GUNNER
        gunnerPieces.add(Pair(burrower, 1))

        //MELEE
        meleePieces.add(Pair(scrapper, 3))

        //PULL

        //RAM

        //SWOOP


        Log.d("UPDATE USER COLLECTION", this.toString())



    }

}