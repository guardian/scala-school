package com.gu.scalaschool.class2

object Race {
  implicit val jsonWrites: JsonWrites[Race] = ???
}

sealed trait Race

case object Human extends Race
case object Dwarf extends Race
case object Elf extends Race

object Profession {
  implicit val jsonWrites: JsonWrites[Profession] = ???
}

sealed trait Profession

case object Fighter extends Profession
case object Mage extends Profession
case object Thief extends Profession
case object ProductManager extends Profession

object Item {
  implicit val jsonWrites: JsonWrites[Item] = ???
}

sealed trait Item

case object MrPointy extends Item
case object SkybreakSpatterlight extends Item

object Player {
  implicit val jsonWrites: JsonWrites[Player] = ???
}

case class Player(
  name: String,
  race: Race,
  profession: Profession,
  goldPieces: Int,
  inventory: Seq[Item]
)
