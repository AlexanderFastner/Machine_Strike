package com.example.machinestrike.ui.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.machinestrike.ui.difficulty.DifficultySelection

@Composable
fun GameScreen(

){
    Scaffold (
        //add pause button in top right
        //save
        //restart
        //back to menu
    ) { innerPadding ->
        Column(
            //contains main game screen
            //background layer
            //gameBoard
            //way to show movement/stats for selected piece- maybe a bottom bar?
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text("COMING SOON")
            //TODO
        }
    }
}