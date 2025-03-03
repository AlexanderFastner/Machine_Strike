package com.example.machinestrike.ui.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.Destinations
import com.example.machinestrike.ui.theme.MachineStrikeTheme
import com.example.machinestrike.ui.theme.Purple40
import com.example.machinestrike.ui.Navigation.NavigationButton


@Composable
fun HomeScreen(
    navController: NavController,
){

    //header
    //title
    //graphic..
    Spacer(modifier = Modifier.height(24.dp))
    OptionsList(navController)
    Spacer(modifier = Modifier.height(24.dp))

}

@Composable
fun OptionsList(
    navController: NavController,
){
    Column {
        NavigationButton(
            onClick = { navController.navigate(Destinations.QUICKPLAY) },
            text = "Quick Play",
            modifier = Modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.MULTIPLAYER) },
            text = "Multiplayer",
            modifier = Modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.SETTINGS) },
            text = "Settings",
            modifier = Modifier.size(240.dp, 60.dp)
        )
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

