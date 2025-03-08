package com.example.machinestrike.ui.selectpieces

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
fun SelectPiecesScreen(
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
                    Text("Select Pieces")
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
            PieceSelection(navController)
            Spacer(modifier = Modifier.height(40.dp))

        }
    }
}

@Composable
fun PieceSelection (
    navController: NavController,
){
    Column {
        Text("Placeholder for coming pieces")
        //TODO
        //lazy list or grid or column of some kind
        //make cards for the pieces
        //make collection of pieces
        //only choose up to 9? X points
        //navigate on to GameScreen and start game
        //remember lifecycle of app and background processes
    }
}



@Preview
@Composable
fun PreviewSelectPiecesScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            SelectPiecesScreen(navController = rememberNavController())
        }
    }
}