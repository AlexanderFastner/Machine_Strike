package com.example.machinestrike.ui.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.Destinations
import com.example.machinestrike.ui.theme.MachineStrikeTheme



@Composable
fun HomeScreen(
    navController: NavController,
){
    Column {
        Button(onClick = { navController.navigate(Destinations.QUICKPLAY) }) {
            Text("Quick Play")
        }
        Button(onClick = { navController.navigate(Destinations.MULTIPLAYER) }) {
            Text("Multiplayer")
        }
        Button(onClick = { navController.navigate(Destinations.SETTINGS) }) {
            Text("Settings")
        }
    }
}



@Composable
fun NavigationButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = text)
    }
}



@Preview
@Composable
fun PreviewHomeScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            HomeScreen(navController = rememberNavController())
        }
    }
}

