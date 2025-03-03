package com.example.machinestrike.ui.selectboard

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
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.Destinations
import com.example.machinestrike.ui.navigation.NavigationButton
import com.example.machinestrike.ui.theme.MachineStrikeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectBoardScreen(
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
                    Text("Select Board")
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
            BoardSelection(navController)
            Spacer(modifier = Modifier.height(40.dp))

        }
    }
}

@Composable
fun BoardSelection (
    navController: NavController,
){

    Column {
        NavigationButton(
            onClick = { navController.navigate(Destinations.PIECESELECT) },
            text = "Standard",
            modifier = Modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        //BASIC means randomized starter board
        NavigationButton(
            onClick = { navController.navigate(Destinations.PIECESELECT) },
            text = "Basic",
            modifier = Modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.PIECESELECT) },
            text = "Asymmetric",
            modifier = Modifier.size(240.dp, 60.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        NavigationButton(
            onClick = { navController.navigate(Destinations.PIECESELECT) },
            text = "Custom",
            modifier = Modifier.size(240.dp, 60.dp)
        )
    }
}



@Preview
@Composable
fun PreviewSelectBoardScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            SelectBoardScreen(navController = rememberNavController())
        }
    }
}