package com.example.machinestrike.ui.homescreen

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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.Destinations
import com.example.machinestrike.ui.theme.MachineStrikeTheme
import com.example.machinestrike.ui.navigation.NavigationButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    options: List<String>,
    modifier: Modifier,
){
    //header
    //graphic..
    //background
    Scaffold (
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Machine Strike")
                }
            )
        },
    ){ innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = modifier.height(40.dp))
            OptionsList(navController, modifier)
            Spacer(modifier = modifier.height(40.dp))

        }
    }
}

@Composable
fun OptionsList(
    navController: NavController,
    modifier: Modifier,
){
    Column () {
        Spacer(modifier = modifier.height(200.dp))

        NavigationButton(
            onClick = { navController.navigate(Destinations.DIFFICULTY) },
            text = "Quick Play",
            modifier = modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = modifier.height(40.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.MULTIPLAYER) },
            text = "Multiplayer",
            modifier = modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = modifier.height(40.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.COLLECTION) },
            text = "Collection",
            modifier = modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = modifier.height(40.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.SETTINGS) },
            text = "Settings",
            modifier = modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = modifier.height(40.dp))

    }
}



@Preview
@Composable
fun PreviewHomeScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            HomeScreen(navController = rememberNavController(), modifier = Modifier)
        }
    }
}

