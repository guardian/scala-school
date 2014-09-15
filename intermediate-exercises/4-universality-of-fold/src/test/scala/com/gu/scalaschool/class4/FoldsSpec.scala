package com.gu.scalaschool.class4

import org.scalatest.{Matchers, FlatSpec}
import Folds._

class FoldsSpec extends FlatSpec with Matchers {
  "sum" should "sum a list of numbers" in {
    sum(Cons(1, Cons(2, Cons(3, EmptyList)))) shouldEqual 6
  }

  "and" should "return true if all the list items are true" in {
    and(Cons(true, Cons(true, Cons(true, Cons(true, EmptyList))))) shouldEqual true
  }

  it should "return false if any list items are false" in {
    and(Cons(true, Cons(false, Cons(true, EmptyList)))) shouldEqual false
  }

  "or" should "return true if any of the list items are true" in {
    or(Cons(false, Cons(false, Cons(true, Cons(false, EmptyList))))) shouldEqual true
  }

  it should "return false if all of the list items are false" in {
    or(Cons(false, Cons(false, Cons(false, Cons(false, EmptyList))))) shouldEqual false
  }

  "max" should "return the maximum number in a list" in {
    max(Cons(1, Cons(-40, Cons(45, Cons(2, Cons(8, EmptyList)))))) shouldEqual 45
  }

  "fold" should "behave as specified" in {
    fold(Cons(0, Cons(-21, Cons(20, Cons(15, EmptyList)))), 0) { (acc: Int, n: Int) =>
      Math.abs(acc) max Math.abs(n)
    } shouldEqual 21
  }

  "map" should "map a function over a list" in {
    map(Cons(1, Cons(2, Cons(3, Cons(4, EmptyList))))) { n => n * n } shouldEqual Cons(1, Cons(4, Cons(9, Cons(16, EmptyList))))
  }

  "filter" should "filter by the supplied predicate" in {
    filter(Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, EmptyList))))))(_ % 2 == 0) shouldEqual Cons(2, Cons(4, EmptyList))
  }
}
