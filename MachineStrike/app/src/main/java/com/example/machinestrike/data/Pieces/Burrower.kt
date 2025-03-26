package com.example.machinestrike.data.Pieces


class Burrower(
    override var name: String = "Burrower",
    override var health: Int = 4,
    override var baseDamage: Int = 2,
    override var attackRange: Int = 2,
    override var movement: Int = 2,
    override var armor: Armor = Armor.F,
    override var weakPoint: WeakPoint = WeakPoint.B,
    override var victoryPoints: Int = 1,
    override var skill: MachineSkill = MachineSkill.NONE,
    override var rarity: Rarity = Rarity.COMMON,
    override var machineType: MachineType = MachineType.MELEE,

    override var placed: Boolean = false,
) : Piece {

}