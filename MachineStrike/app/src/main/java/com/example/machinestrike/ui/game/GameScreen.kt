package com.example.machinestrike.ui.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.ui.MachineStrikeViewModel
import com.example.machinestrike.ui.difficulty.DifficultyScreen
import com.example.machinestrike.ui.theme.MachineStrikeTheme

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

@Preview
@Composable
fun PreviewGameScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            GameScreen()
        }
    }
}