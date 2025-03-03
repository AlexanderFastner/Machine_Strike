package com.example.machinestrike.ui.multiplayer

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.ui.homescreen.HomeScreen
import com.example.machinestrike.ui.theme.MachineStrikeTheme

@Composable
fun MultiplayerScreen(
    navController: NavController,
){
    Column() {
        Text("Coming Soon!")
        //TODO
    }
}




@Preview
@Composable
fun PreviewMultiplayerScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            MultiplayerScreen(navController = rememberNavController())
        }
    }
}
