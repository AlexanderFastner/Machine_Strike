package com.example.machinestrike.data.Pieces

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.machinestrike.ui.theme.MachineStrikeTheme

@Composable
fun PieceCard(
    piece: Piece,
    count: Int,
) {
    Spacer(Modifier.height(200.dp))
    Card (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(getColorFromRarity(piece.rarity)),
    ){
        //TODO MAKE ICON
        //icon and all stats
        Text(text = piece.name, color = Color.Black)
        Text(text = count.toString(), color = Color.Black)

    }

}

@Composable
fun BoxedPieceCard(
    piece: Piece,
    count: Int,
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Yellow)
    ) {
        PieceCard(piece, count)
    }
}


@Preview
@Composable
fun PreviewBoxedPieceCardBurrower(){
    MachineStrikeTheme {
        var burrower = Burrower()
        BoxedPieceCard(burrower, 1)
    }
}


@Preview
@Composable
fun PreviewPieceCardBurrower(){
    MachineStrikeTheme {
        var burrower = Burrower()
        PieceCard(burrower, 1)
    }
}

@Preview
@Composable
fun PreviewPieceCardScrapper(){
    MachineStrikeTheme {
        var scrapper = Scrapper()
        PieceCard(scrapper, 0)
    }
}