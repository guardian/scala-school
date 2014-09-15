package com.gu.scalaschool.class4

object Folds {
  /** to stop you using all the useful things defined on Scala's own List type let's define a simple crappy one here */
  object LinkedList {
    def empty[A]: LinkedList[A] = EmptyList
  }

  sealed trait LinkedList[+A]

  case object EmptyList extends LinkedList[Nothing]
  case class Cons[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

  /** Exercise 1
    *
    * Define `sum` using a recursive function.
    *
    * Given a list of numbers, it should add them all up and return the sum.
    *
    * If you want to show off, make it tail-recursive.
    *
    * PROTIP: If you annotate a tail recursive function with scala.annotation.tailrec, the compiler will tell you if it
    * can't tail-call optimise it. Don't know what that means? Ask your teacher!
    */
  def sum(as: LinkedList[Double]): Double = ???

  /** Exercise 2
    *
    * Define `and` using a recursive function.
    *
    * Given a list of booleans, it should return true if every boolean in the list is true.
    */
  def and(as: LinkedList[Boolean]): Boolean = ???

  /** Exercise 3
    *
    * Define `or` using a recursive function.
    *
    * Given a list of booleans, it should return true if any boolean in the list is true.
    */
  def or(as: LinkedList[Boolean]): Boolean = ???

  /** Exercise 4
    *
    * Define `max` using a recursive function.
    *
    * Given a list of numbers, it should return the maximum number from the list.
    */
  def max(as: LinkedList[Double]): Double = ???


  /** You're probably finding this a little repetitive now. We can express all of the above in terms of a fold.
    *
    * To fold up a list you start off with some initial value. You then look at the leftmost value of the list, combine
    * that with your current value in some useful way (for a sum, for example, you would add them together), and that
    * becomes your new value. You keep doing that until the list is empty, at which point you've got your answer.
    *
    * e.g.
    *
    * You want to sum the list 1 :: 2 :: 3 :: Nil.
    *
    * As we're adding up the numbers we're going to start with 0.
    *
    * We then consider the first number in the list - 1 + 0 == 1.
    *
    * At that point we have the remainder:
    *
    * 2 :: 3 :: Nil.
    *
    * We consider the next value in the list - 2 + 1 == 3.
    *
    * Now we have the remainder:
    *
    * 3 :: Nil.
    *
    * Then the 3 finally:
    *
    * 3 + 3 == 6.
    *
    * OK, we've folded up the list.
    *
    * I want you to fill in fold below. The type signature might be a little scary, but there are examples below of the
    * above functions defined as a fold, which should guide you a little bit as to what it is going on.
    */
  def fold[A, B](as: LinkedList[A], initialValue: B)(f: (B, A) => B): B = ???

  object foldExamples {
    def sum(as: LinkedList[Double]) = fold(as, 0d) { (accumulator: Double, a: Double) =>
      accumulator + a
    }

    def and(as: LinkedList[Boolean]) = fold(as, true) { (accumulator: Boolean, a: Boolean) =>
      accumulator && a
    }

    def or(as: LinkedList[Boolean]) = fold(as, false) { (accumulator: Boolean, a: Boolean) =>
      accumulator || a
    }

    /** This one's pretty nasty actually!
      *
      * Not sure how you dealt with this above, but `max` is actually what we refer to in maths and programming as a
      * 'partial function'. That is, it's not defined for some inputs. You can't meaningfully say what the 'maximum'
      * number of an empty list is here, so we throw an error.
      *
      * Though we're only throwing an error to be consistent with the type signature above. It's probably better in this
      * scenario to return the Option itself - that way the function itself is total, and the user is made aware that
      * they should deal with the scenario where the list is empty by the type signature itself.
      */
    def max(as: LinkedList[Double]) = (fold(as, Option.empty[Double]) { (maybeAcc: Option[Double], a: Double) =>
      maybeAcc map { acc =>
        acc + a
      } orElse {
        Option(a)
      }
    }) getOrElse {
      throw new RuntimeException("max is not defined for an empty list")
    }
  }

  /** OK cool, so we've defined fold! What else can we do with it?
    *
    * Well, actually, you can accumulate much more interesting values, such as lists themselves. Let's consider how we
    * might reverse a list using a fold:
    */
  def reverse[A](as: LinkedList[A]): LinkedList[A] = fold(as, LinkedList.empty[A]) { (accumulator: LinkedList[A], a: A) =>
    Cons(a, accumulator)
  }

  /** Exercise 5:
    *
    * Let's define some more useful list operations using fold.
    *
    * Define map in terms of fold. Map should take a list of as, then map the function over them, producing a list of
    * bs:
    */
  def map[A, B](as: LinkedList[A])(f: A => B): LinkedList[B] = ???

  /** Exercise 6:
    *
    * Define filter in terms of fold.
    *
    * Filter should return the list except the items for which the function returns false:
    */
  def filter[A](as: LinkedList[A])(f: A => Boolean): LinkedList[A] = ???
}
