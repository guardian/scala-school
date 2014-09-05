package com.gu.scalaschool.class1

/** Make your own case class! */
object Rectangle {
  def apply(width: Int, height: Int): Rectangle = ???

  def unapply(rect: Rectangle): Option[(Int, Int)] = ???
}

class Rectangle(val width: Int, val height: Int) {
  override def equals(obj: Any): Boolean = ???

  override def hashCode(): Int = ???

  override def toString: String = ???

  def copy(width: Int = this.width, height: Int = this.height): Rectangle = ???
}
