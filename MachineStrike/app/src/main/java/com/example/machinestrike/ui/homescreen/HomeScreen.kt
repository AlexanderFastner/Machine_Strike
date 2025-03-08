package com.example.machinestrike.ui.homescreen

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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.Destinations
import com.example.machinestrike.data.DataSource
import com.example.machinestrike.data.NavigationOption
import com.example.machinestrike.ui.theme.MachineStrikeTheme
import com.example.machinestrike.ui.navigation.NavigationButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    options: List<NavigationOption>,
    modifier: Modifier,
){
    //header
    //graphic..
    //background
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
                    "Machine Strike HOMESCREEN",
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
            OptionsList(navController, options, modifier)
        }
    }
}

@Composable
fun OptionsList(
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
                    Log.d("Button clicked", item.label)},
                text = item.label,
                modifier = modifier.size(240.dp, 60.dp)
            )
            Spacer(modifier = modifier.height(40.dp))
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            HomeScreen(
                navController = rememberNavController(),
                options = DataSource.homeScreenOptions,
                modifier = Modifier
            )
        }
    }
}

