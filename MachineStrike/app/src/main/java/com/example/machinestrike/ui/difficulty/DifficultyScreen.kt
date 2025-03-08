package com.example.machinestrike.ui.difficulty

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.Destinations
import com.example.machinestrike.ui.MachineStrikeViewModel
import com.example.machinestrike.ui.theme.MachineStrikeTheme
import com.example.machinestrike.ui.navigation.NavigationButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DifficultyScreen(
    navController: NavController,
){
    Scaffold (
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Select Difficulty")
                }
            )
        },
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            DifficultySelection(navController)
            Spacer(modifier = Modifier.height(40.dp))

        }
    }
}

@Composable
fun DifficultySelection (
    navController: NavController,
){

    //save selection ... somewhere

    Column {
        NavigationButton(
            onClick = { navController.navigate(Destinations.BOARDSELECT) },
            text = "Easy",
            modifier = Modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.BOARDSELECT) },
            text = "Medium",
            modifier = Modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.BOARDSELECT) },
            text = "Hard",
            modifier = Modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.BOARDSELECT) },
            text = "Expert",
            modifier = Modifier.size(240.dp, 60.dp)
        )
    }
}



@Preview
@Composable
fun PreviewDifficultyScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            DifficultyScreen(navController = rememberNavController())
        }
    }
}