package com.example.machinestrike.data.Pieces

import androidx.compose.ui.graphics.Color
import com.example.machinestrike.ui.theme.CommonGreen
import com.example.machinestrike.ui.theme.LegendaryGold
import com.example.machinestrike.ui.theme.RarePurple
import com.example.machinestrike.ui.theme.UncommonBlue


//This needs to be an interface of functions and variables that all pieces share
enum class Armor{
    F,R,B,L,
    FR, FL, FB, LR,
    BR, BL,
    FRB, FRL,
    BLF, RBL
}

enum class WeakPoint{
    F,R,B,L,
    FR, FL, FB, LR,
    BR, BL,
    FRB, FRL,
    BLF, RBL
}

//Gallop - When attacking from Grassland terrain, gain +1 Combat Power. - Charger, Grazer
//Sweep - (description needed) - Ravager
//Stalk - When attacking from Forest terrain, gain +1 Combat Power. - Stalker, Clawstrider
//Empower - At the start of each turn, all friendly machines within Attack Range gain +1 Attack Power. Effects can stack. - Longleg, Leaplasher
//Spray - At the start of each turn, all pieces within Attack Range lose -1 health. - Bristleback, Bellowback, Slaughterspine
//Burn - Attacking on Forest Terrain will turn that into Grassland Terrain. - Elemental Clawstrider, Fireclaw, Scorcher

enum class MachineSkill {
    ALTERTERRAIN, BLIND, BURN, CLIMB, EMPOWER, FREEZE, GALLOP, GROWTH, HIGHGROUND, NONE, RETALIATE, SHIELD, SPRAY, STALK, SWEEP, WHIPLASH
}

enum class Rarity {
    COMMON, UNCOMMON, RARE, LEGENDARY
}

fun getColorFromRarity(rarity: Rarity): Color {
    return when (rarity) {
        Rarity.COMMON -> CommonGreen
        Rarity.UNCOMMON -> UncommonBlue
        Rarity.RARE -> RarePurple
        Rarity.LEGENDARY -> LegendaryGold
    }
}

enum class MachineType{
    DASH, GUNNER, MELEE, PULL, RAM, SWOOP
}

interface Piece {

    var name: String
    var health: Int
    var baseDamage: Int
    var attackRange: Int
    var movement: Int
    var armor: Armor
    var weakPoint: WeakPoint
    var victoryPoints: Int
    var skill: MachineSkill
    var rarity: Rarity
    var machineType: MachineType

    var placed: Boolean

    //TODO FIGURE OUT IF IT NEEDS TO BE AN IMAGE OR BITMAP OR WHAT TO DRAW ON BOARD

    //TODO figure out where each bit of logic goes (in PLayer interface - implemented by  a human player and ai players...)
    //piece selected
    //check legal moves
    //display legal moves
    //wait user input
    //if legal move then execute
        //if friendly piece selected go to step 1
        //if legal move and hostile
            //attack logic
        //else do nothing


    fun movement(){

    }

    fun getPosition(){

    }

    //TODO on game start call set position to place
    fun setPosition(){
//        placed = true
    }

    fun attack(){

    }


}