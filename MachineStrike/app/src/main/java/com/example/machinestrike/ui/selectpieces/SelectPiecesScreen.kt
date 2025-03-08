package com.example.machinestrike.ui.selectpieces

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.Destinations
import com.example.machinestrike.data.DataSource
import com.example.machinestrike.data.NavigationOption
import com.example.machinestrike.data.SelectionButtons
import com.example.machinestrike.ui.navigation.NavigationButton
import com.example.machinestrike.ui.theme.MachineStrikeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectPiecesScreen(
    navController: NavController,
    navigationOptions: List<NavigationOption>,
    modifier: Modifier = Modifier,
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
                    "Select Pieces",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
    ){ innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                PieceSelection(
                    modifier = modifier
                )
                Spacer(modifier = Modifier.height(40.dp))


            }

            //TODO ONLY LET USER CLICK NEXT IF AT LEAST 1 PIECE IS SELECTED

            navigationOptions.forEach { item ->
                NavigationButton(
                    onClick = {
                        navController.navigate(item.destination)
                        Log.d("Button clicked", item.label)
                    },
                    text = item.label,
                    modifier = Modifier
                        .size(160.dp, 60.dp)
                        .align(Alignment.BottomEnd)
                        .padding(end = 8.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
fun PieceSelection (
    modifier: Modifier = Modifier,
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
            SelectPiecesScreen(
                navController = rememberNavController(),
                navigationOptions = DataSource.PieceSelectScreenNext,
                modifier = Modifier
            )
        }
    }
}