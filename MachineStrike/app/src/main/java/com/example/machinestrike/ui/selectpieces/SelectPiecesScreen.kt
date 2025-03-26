package com.example.machinestrike.ui.selectpieces

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.data.DataSource
import com.example.machinestrike.data.NavigationOption
import com.example.machinestrike.data.Pieces.Burrower
import com.example.machinestrike.data.Pieces.Piece
import com.example.machinestrike.data.Pieces.PieceCard
import com.example.machinestrike.data.Pieces.Scrapper
import com.example.machinestrike.ui.collection.UserCollection
import com.example.machinestrike.ui.navigation.NavigationButton
import com.example.machinestrike.ui.theme.DarkGreen
import com.example.machinestrike.ui.theme.MiddleGreen
import com.example.machinestrike.ui.theme.LightGreen
import com.example.machinestrike.ui.theme.MachineStrikeTheme
import kotlinx.coroutines.launch

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
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {

            val userCollection = UserCollection()
            PieceSelection(
                userCollection = userCollection,
                modifier = modifier
            )

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
//TODO
//Tabs for different types of machines

//lazy list or grid or column of some kind
//make cards for the pieces
//make collection of all pieces
//only choose up to 9? X points
//navigate on to GameScreen and start game
//remember lifecycle of app and background processes

@Composable
fun PieceSelection (
    userCollection: UserCollection,
    modifier: Modifier = Modifier,
){
    ScrollableTabLayout(userCollection, 7, modifier)
}

@Composable
fun ScrollableTabLayout(
    userCollection: UserCollection,
    tabIndex: Any,
    modifier: Modifier
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0.0f,
        pageCount = { 7 },
    )
    val scope = rememberCoroutineScope()

    val tabs = listOf("All", "DASH", "GUNNER", "MELEE", "PULL", "RAM", "SWOOP")

    //TODO THIS NEEDS TO BE FIXED TO RUN AT RIGTH TIME
    userCollection.loadAllUserPieces()

    val tabContents= listOf(
        userCollection.allPieces,
        userCollection.dashPieces,
        userCollection.gunnerPieces,
        userCollection.meleePieces,
        userCollection.pullPieces,
        userCollection.ramPieces,
        userCollection.swoopPieces,
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
//        Spacer(modifier = modifier.height(100.dp))
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = DarkGreen,
            contentColor = LightGreen,
            divider = {},
            edgePadding = 0.dp,
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    text = { Text(title) }
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f).background(MiddleGreen)
        ) { page ->

            //TODO
            //ADD ICONS
            //ADD STATS
            //ADD NUMBER SELECTED
            //STANDARD VAL MASTER LIST OF ALL PIECES - only enable those that are in collection
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                tabContents[page].forEach { piece ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .background(Color.Yellow)
                    ) {
                        PieceCard(piece.first, piece.second)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
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