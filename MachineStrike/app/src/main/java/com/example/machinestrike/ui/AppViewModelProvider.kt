package com.example.machinestrike.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.machinestrike.MachineStrikeApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
//            val app = (this[AndroidViewModelFactory.APPLICATION_KEY] as MachineStrikeApplication)
//            MachineStrikeViewModel(app.container.gameRepository)
            MachineStrikeViewModel()
        }
    }
}

//fun CreationExtras.MachineStrikeApplication(): MachineStrikeApplication? =
//    (this[AndroidViewModelFactory.APPLICATION_KEY] as? MachineStrikeApplication)