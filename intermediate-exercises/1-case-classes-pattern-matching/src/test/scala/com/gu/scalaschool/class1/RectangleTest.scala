package com.gu.scalaschool.class1

import org.scalatest.{Matchers, FlatSpec}

class RectangleTest extends FlatSpec with Matchers {
  "equals" should "be true for two Rectangles with the same width and height" in {
    new Rectangle(10, 10) shouldEqual new Rectangle(10, 10)
  }

  it should "be false for two Rectangles with different widths" in {
    new Rectangle(9, 10) should not equal new Rectangle(10, 10)
  }

  it should "be false for two Rectangles with different heights" in {
    new Rectangle(10, 9) should not equal new Rectangle(10, 10)
  }

  "hashCode" should "be equal for two Rectangles with the same width and height" in {
    new Rectangle(5, 5).hashCode shouldEqual new Rectangle(5, 5).hashCode()
  }

  it should "not pretty much always be the same" in {
    Set(
      new Rectangle(1, 1).hashCode(),
      new Rectangle(2, 5).hashCode(),
      new Rectangle(5, 5).hashCode(),
      new Rectangle(100, 2).hashCode()
    ) should not have size(1)
  }

  "toString" should "provide a good String representation of a Rectangle" in {
    new Rectangle(3, 3).toString shouldEqual "Rectangle(3,3)"
  }

  "copy" should "allow you to copy a rectangle with a new width set" in {
    new Rectangle(4, 4).copy(width = 5) shouldEqual new Rectangle(5, 4)
  }

  it should "allow you to copy a rectangle with a new height set" in {
    new Rectangle(4, 4).copy(height = 5) shouldEqual new Rectangle(4, 5)
  }

  it should "allow you to copy a rectangle with a new width and height set" in {
    new Rectangle(3, 3).copy(width = 4, height = 5) shouldEqual new Rectangle(4, 5)
  }

  "apply" should "create a new Rectangle" in {
    Rectangle(3, 4) shouldEqual new Rectangle(3, 4)
  }

  "unapply" should "deconstruct a Rectangle" in {
    new Rectangle(3, 4) match {
      case Rectangle(width, height) =>
        width shouldEqual 3
        height shouldEqual 4
      case _ => fail("unapply did not return Some for Rectangle")
    }
  }
}
