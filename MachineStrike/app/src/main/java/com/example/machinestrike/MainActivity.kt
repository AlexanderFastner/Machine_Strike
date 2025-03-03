package com.example.machinestrike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import com.example.machinestrike.ui.homescreen.HomeScreen
import com.example.machinestrike.ui.theme.MachineStrikeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MachineStrikeTheme {
                MachineStrikeScreen()
            }
        }
    }
}

