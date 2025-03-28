package com.example.machinestrike.ui.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.machinestrike.ui.theme.Purple40
import com.example.machinestrike.ui.theme.LightGreen
import com.example.machinestrike.ui.theme.MiddleGreen
import com.example.machinestrike.ui.theme.DarkGreen


@Composable
fun NavigationButtonGroup(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        shape = CutCornerShape(25),
        colors = if (selected) {
            ButtonDefaults.buttonColors(
                containerColor = LightGreen,
                contentColor = Color.Black
            )
            }else{
            ButtonDefaults.buttonColors(
                containerColor = DarkGreen,
                contentColor = Color.White
            )
        },
        border = BorderStroke(2.dp, Purple40),
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun NavigationButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        shape = CutCornerShape(25),
        colors = ButtonDefaults.buttonColors(
                containerColor = LightGreen,
                contentColor = Color.Black
            ),
        border = BorderStroke(2.dp, Purple40),
        modifier = modifier
    ) {
        Text(text = text)
    }
}