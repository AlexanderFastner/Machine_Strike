package com.example.machinestrike

import android.app.Application
import com.example.machinestrike.data.AppContainer
import com.example.machinestrike.data.AppDataContainer

class MachineStrikeApplication : Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}