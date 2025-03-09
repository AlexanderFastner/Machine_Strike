package com.example.machinestrike.data.Pieces

import java.lang.Boolean.FALSE

class Scrapper(
    override var health: Int = 5,
    override var baseDamage: Int = 2,
    override var attackRange: Int = 2,
    override var movement: Int = 3,
    override var armor: Armor = Armor.F,
    override var weakPoint: WeakPoint = WeakPoint.B,
    override var victoryPoints: Int = 2,
    override var skill: MachineSkill = MachineSkill.NONE,
    override var rarity: Rarity = Rarity.COMMON,

    override var placed: Boolean = FALSE,
) : Piece {


}