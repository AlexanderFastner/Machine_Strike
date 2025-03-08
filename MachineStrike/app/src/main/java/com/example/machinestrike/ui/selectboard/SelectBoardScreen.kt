package com.example.machinestrike.ui.selectboard

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
import com.example.machinestrike.ui.navigation.SelectionButton
import com.example.machinestrike.ui.theme.MachineStrikeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectBoardScreen(
    navController: NavController,
    options: List<SelectionButtons>,
    navigationOptions: List<NavigationOption>,
    modifier: Modifier = Modifier,
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
                    "Select Board",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            //TODO
            //add image of selected board

            BoardSelection(
                navController,
                options,
                navigationOptions,
                modifier
            )
        }
    }
}

@Composable
fun BoardSelection (
    navController: NavController,
    options: List<SelectionButtons>,
    navigationOptions: List<NavigationOption>,
    modifier: Modifier = Modifier,
){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            //TODO switch all these to just change the image being shown above
            //TODO add viewmodel for these buttons to send data to
            //TODO change gameRepository settings
            //also need to add this for difficulty + piece selection


            //TODO MAKE THE SELECTED OPTION HIGHLIGHT!
            Spacer(modifier = Modifier.height(150.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                options.forEach { item ->
                    NavigationButton(
                        onClick = {
                            //TODO MAKE THIS ADD TO UI STATE
                            Log.d("Button clicked", item.label)},
                        text = item.label,
                        modifier = Modifier.size(240.dp, 60.dp)
                    )
                    Spacer(modifier = modifier.height(40.dp))
                }
            }
        }
        navigationOptions.forEach { item ->
            NavigationButton(
                onClick = {
                    navController.navigate(item.destination)
                    Log.d("Button clicked", item.label)},
                text = item.label,
                modifier = Modifier
                    .size(160.dp, 60.dp)
                    .align(Alignment.BottomEnd)
                    .padding(end = 8.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSelectBoardScreen(){
    MaterialTheme {
        MachineStrikeTheme {
            SelectBoardScreen(
                navController = rememberNavController(),
                options = DataSource.selectBoardScreenOptions,
                navigationOptions = DataSource.BoardSelectSceenNext,
                modifier = Modifier
            )
        }
    }
}