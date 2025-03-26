package com.example.machinestrike.ui.difficulty

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.Destinations
import com.example.machinestrike.data.DataSource
import com.example.machinestrike.data.NavigationOption
import com.example.machinestrike.ui.MachineStrikeViewModel
import com.example.machinestrike.ui.homescreen.DummyOptionsList
import com.example.machinestrike.ui.homescreen.OptionsList
import com.example.machinestrike.ui.theme.MachineStrikeTheme
import com.example.machinestrike.ui.navigation.NavigationButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DifficultyScreen(
    navController: NavController,
    options: List<NavigationOption>,
//    backStackEntry: NavBackStackEntry?,
    modifier: Modifier = Modifier,
    viewModel: MachineStrikeViewModel?
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
                    "Select Difficulty",
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
            if (viewModel != null) {
                DifficultySelection(navController, options, modifier, viewModel)

            }
            else{
                DummyDifficultySelection(navController, options, modifier)
            }
        }
    }
}

@Composable
fun DifficultySelection (
    navController: NavController,
    options: List<NavigationOption>,
//    backStackEntry: NavBackStackEntry,
    modifier: Modifier = Modifier,
    viewModel: MachineStrikeViewModel
){
    Column {
        Spacer(modifier = modifier.height(200.dp))
        options.forEach { item ->
            NavigationButton(
                onClick = {
                    viewModel.setDifficulty(item.label)
                    val currentDifficulty = viewModel.uiState.value.difficulty
                    Log.d("set difficulty", currentDifficulty)
//                    Log.d("get gamemode in difficulty", viewModel.uiState.value.gameType)
                    navController.navigate(item.destination)
                    Log.d("Button clicked", item.label)
                },
                text = item.label,
                modifier = Modifier.size(240.dp, 60.dp)
            )
            Spacer(modifier = modifier.height(40.dp))
        }
    }
}

@Composable
fun DummyDifficultySelection (
    navController: NavController,
    options: List<NavigationOption>,
    modifier: Modifier = Modifier,
){
    Column {
        Spacer(modifier = modifier.height(200.dp))
        options.forEach { item ->
            NavigationButton(
                onClick = {
                    navController.navigate(item.destination)
                    Log.d("Button clicked", item.label)
                },
                text = item.label,
                modifier = Modifier.size(240.dp, 60.dp)
            )
            Spacer(modifier = modifier.height(40.dp))
        }
    }
}


@Preview
@Composable
fun PreviewDifficultyScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            DifficultyScreen(
                navController = rememberNavController(),
                options = DataSource.difficultyScreenOptions,
//                backStackEntry = null,
                modifier = Modifier,
                viewModel = null,
            )
        }
    }
}