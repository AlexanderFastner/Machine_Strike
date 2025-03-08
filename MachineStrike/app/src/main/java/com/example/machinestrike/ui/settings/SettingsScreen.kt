package com.example.machinestrike.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.ui.homescreen.HomeScreen
import com.example.machinestrike.ui.theme.MachineStrikeTheme

@Composable
fun SettingsScreen(
    navController: NavController,
){
    Scaffold (
        topBar = {
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Settings",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            Text("Coming Soon!")
            //TODO
        }
    }
}


@Preview
@Composable
fun PreviewSettingsScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            SettingsScreen(navController = rememberNavController())
        }
    }
}