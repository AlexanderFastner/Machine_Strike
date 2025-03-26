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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.Destinations
import com.example.machinestrike.data.DataSource
import com.example.machinestrike.data.NavigationOption
import com.example.machinestrike.data.SelectionButtons
import com.example.machinestrike.ui.MachineStrikeViewModel
import com.example.machinestrike.ui.navigation.NavigationButton
import com.example.machinestrike.ui.navigation.SelectionButton
import com.example.machinestrike.ui.theme.MachineStrikeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.machinestrike.ui.navigation.NavigationButtonGroup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectBoardScreen(
    navController: NavController,
    options: List<SelectionButtons>,
    navigationOptions: List<NavigationOption>,
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

            if (viewModel != null) {
                BoardSelection(
                    navController,
                    options,
                    navigationOptions,
                    modifier,
                    viewModel
                )
            }
            else{
                DummyBoardSelection(
                    navController,
                    options,
                    navigationOptions,
                    modifier
                )
            }
        }
    }
}

@Composable
fun BoardSelection (
    navController: NavController,
    options: List<SelectionButtons>,
    navigationOptions: List<NavigationOption>,
    modifier: Modifier = Modifier,
    viewModel: MachineStrikeViewModel
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

            Spacer(modifier = Modifier.height(150.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                var selectedOption by remember { mutableStateOf("") }
                options.forEach { item ->
                    NavigationButtonGroup(
                        onClick = {
                            selectedOption = item.label
                            viewModel.setBoard(item.label)
                            Log.d("Button clicked", item.label)
                            Log.d("Viewmodel Updated", viewModel.uiState.value.board)},
                        selected = selectedOption == item.label,
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


//TODO REMEMBER TO KEEP UP TO DATE
@Composable
fun DummyBoardSelection (
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
            var selectedOption by remember { mutableStateOf("") }

            Spacer(modifier = Modifier.height(150.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                options.forEach { item ->
                    NavigationButtonGroup(
                        onClick = {
                            selectedOption = item.label
                            Log.d("Button clicked", item.label)},
                        selected = selectedOption == item.label,
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
                modifier = Modifier,
                viewModel = null
            )
        }
    }
}