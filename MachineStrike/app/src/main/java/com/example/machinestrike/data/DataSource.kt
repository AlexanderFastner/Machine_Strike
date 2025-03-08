package com.example.machinestrike.data


import com.example.machinestrike.Destinations
import com.example.machinestrike.R

//This needs to store the data to make all of the buttons so it can be passed as input to the various screens
//This allows all the ui state to be handled by the main MachineStrikeScreen

data class SelectionButtons(val label: String)
data class NavigationOption(val label: String, val destination: String)

object DataSource {

    val homeScreenOptions = listOf(
        NavigationOption("Quick Play", Destinations.DIFFICULTY),
        NavigationOption("Multiplayer", Destinations.MULTIPLAYER),
        NavigationOption("Collection", Destinations.COLLECTION),
        NavigationOption("Settings", Destinations.SETTINGS),
    )

    val difficultyScreenOptions = listOf(
        NavigationOption("Very Easy", Destinations.BOARDSELECT),
        NavigationOption("Easy", Destinations.BOARDSELECT),
        NavigationOption("Medium", Destinations.BOARDSELECT),
        NavigationOption("Hard", Destinations.BOARDSELECT),
        NavigationOption("Expert", Destinations.BOARDSELECT),
    )

    val selectBoardScreenOptions = listOf(
        SelectionButtons("Standard"),
        SelectionButtons("Basic"),
        SelectionButtons("Asymmetric"),
        SelectionButtons("Custom"),
    )

    val BoardSelectSceenNext = listOf(
        NavigationOption("Next", Destinations.PIECESELECT),
    )

    val PieceSelectScreenNext = listOf(
        NavigationOption("Next", Destinations.PIECESELECT),
    )

    //TODO multiplayerScreen, settings, collection, wiki?
}