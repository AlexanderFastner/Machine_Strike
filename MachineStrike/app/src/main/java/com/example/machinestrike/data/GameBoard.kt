package com.example.machinestrike.data

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.machinestrike.ui.theme.MachineStrikeTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.imageResource
import com.example.machinestrike.R


//TODO improve/ add more default boards
val LinesBoard = listOf(
    5,4,3,2,1,0,5,4,
    5,4,3,2,1,0,5,4,
    5,4,3,2,1,0,5,4,
    5,4,3,2,1,0,5,4,
    5,4,3,2,1,0,5,4,
    5,4,3,2,1,0,5,4,
    5,4,3,2,1,0,5,4,
    5,4,3,2,1,0,5,4
)

val StandardBoard = listOf(
    4,4,4,4,4,4,4,4,
    3,3,3,3,3,3,3,3,
    2,2,2,2,2,2,2,2,
    2,2,2,2,2,2,2,2,
    2,2,2,2,2,2,2,2,
    2,2,2,2,2,2,2,2,
    3,3,3,3,3,3,3,3,
    4,4,4,4,4,4,4,4
)

val DefaultBoard1 = listOf(
    2,2,2,3,2,3,2,2,
    3,3,5,2,3,2,3,2,
    2,2,5,3,3,2,4,3,
    2,4,3,2,4,2,5,2,
    2,5,2,4,2,3,4,2,
    2,4,2,3,3,5,2,2,
    2,3,2,3,2,5,3,3,
    2,2,3,2,3,2,2,2
)


//TODO add a way to make a random board

//TODO add a way for the player to draw a custom board

//TODO maybe add this to the viewModel?

//TODO make a way to have a bigger or smaller board


//TODO change to list of ints 0-5 for various heights
//when ... 1-> corrupt, 2 ->... etc

@Composable
fun GameBoard(
    heights: List<Int>,
    selectedTilesList: Set<Pair<Int, Int>>? = setOf(), // Set of selected tile positions
    onClick: (Int, Int) -> Unit
) {
    val corrupt = ImageBitmap.imageResource(R.drawable.corrupt) //0
    val chasm = ImageBitmap.imageResource(R.drawable.chasm) //1
    val grass = ImageBitmap.imageResource(R.drawable.grass) //2
    val forrest = ImageBitmap.imageResource(R.drawable.forrest) //3
    val hills = ImageBitmap.imageResource(R.drawable.hills) //4
    val mountain = ImageBitmap.imageResource(R.drawable.mountain) //5

    val brushes = Brushes(corrupt, chasm, grass, forrest, hills, mountain)

    // Function to map height to terrain type
    @Composable
    fun heightToTerrain(height: Int): Brush {
        return when (height) {
            0 -> brushes.corruptBrush()
            1 -> brushes.chasmBrush()
            2 -> brushes.grassBrush()
            3 -> brushes.forrestBrush()
            4 -> brushes.hillsBrush()
            5 -> brushes.mountainBrush()
            else -> brushes.corruptBrush()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val rows = heights.chunked(8)
        rows.forEachIndexed { row, rowHeights ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                rowHeights.forEachIndexed { column, height ->
                    val isSelected = selectedTilesList?.contains(Pair(row, column))
                    val terrainBrush = heightToTerrain(height)

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
//                            .background(
//                                when {
//                                    isSelected == true -> Color.Red // Highlight selected tiles //TODO make this a border not a fill
////                                  else -> height.color
//                                    else ->  imageBrush
//                                }
//                            )
                            .background(brush = terrainBrush)

                            .clickable { onClick(row, column) }
                    )
                }
            }
        }
    }
}

@Composable
fun GameScreen() {
    val selectedTilesList = remember { mutableStateOf(setOf<Pair<Int, Int>>()) }

    GameBoard(
        selectedTilesList = selectedTilesList.value,
        heights = StandardBoard,
        onClick = { row, column ->
            // Handle tile click here
            selectedTilesList.value = selectedTilesList.value + setOf(Pair(row, column))
        }
    )
}

@Preview
@Composable
fun PreviewStandardGameScreen() {
    MachineStrikeTheme {
        val selectedTiles = remember { mutableStateOf(setOf(
            Pair(-1,-1)
        ))
        }
        GameBoard(
            selectedTilesList = selectedTiles.value,
            heights = StandardBoard,
            onClick = { row, column ->
                // Handle tile click here
                selectedTiles.value = selectedTiles.value + setOf(Pair(row, column))
            }
        )
    }
}

@Preview
@Composable
fun PreviewDefaultBoardGameScreen() {
    MachineStrikeTheme {
        val selectedTiles = remember { mutableStateOf(setOf(
            Pair(0, 0), // Top-left tile
            Pair(1, 1), // Center tile
        )) }
        GameBoard(
            selectedTilesList = selectedTiles.value,
            heights = DefaultBoard1,
            onClick = { row, column ->
                // Handle tile click here
                selectedTiles.value = selectedTiles.value + setOf(Pair(row, column))
            }
        )
    }
}

