package com.example.machinestrike.data.Pieces

import java.lang.Boolean.FALSE

class Burrower(
    override var health: Int = 4,
    override var baseDamage: Int = 2,
    override var attackRange: Int = 2,
    override var movement: Int = 2,
    override var armor: Armor,
    override var weakPoint: WeakPoint,
    override var victoryPoints: Int = 1,
    override var skill: MachineSkill = MachineSkill.NONE,
    override var rarity: Rarity = Rarity.COMMON,

    override var placed: Boolean = FALSE,
) : Piece {


}