package com.example.machinestrike.ui.multiplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.ui.difficulty.DifficultySelection
import com.example.machinestrike.ui.homescreen.HomeScreen
import com.example.machinestrike.ui.theme.MachineStrikeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiplayerScreen(
    navController: NavController,
){
    Scaffold (
        topBar = {
            Box(
                modifier = Modifier
                    .height(40.dp) // Adjust the height as needed
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Multiplayer",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text("Coming Soon!")
            //TODO

            //Room code input box
            //Search button

            Spacer(modifier = Modifier.height(40.dp))

        }
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
