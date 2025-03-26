package com.example.machinestrike.ui.collection

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
import com.example.machinestrike.data.Pieces.Burrower
import com.example.machinestrike.data.Pieces.Piece
import com.example.machinestrike.ui.navigation.NavigationButton
import com.example.machinestrike.ui.theme.MachineStrikeTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollectionScreen(
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
                    Text("Your Collection")
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
            CollectionList(navController)

        }
    }
}

@Composable
fun CollectionList (
    navController: NavController,
){

    //Collection of all pieces
    //selectors for unlocked, not unlocked
    //icons to sort by types
    //board to show movements

    Column {
        Text("COMING SOON")
        //TODO
    }
}



@Preview
@Composable
fun PreviewCollectionScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            CollectionScreen(navController = rememberNavController())
        }
    }
}