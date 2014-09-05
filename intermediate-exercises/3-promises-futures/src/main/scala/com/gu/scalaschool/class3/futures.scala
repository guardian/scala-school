package com.gu.scalaschool.class3

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try

object futures {
  /** If the future fails, return a future of the failure of the error.
    * If the future succeeds, return a future of the success of the value.
    */
  def extractTry[A](future: Future[A]): Future[Try[A]] = ???

  /** Collect the successful futures into a Seq, ignoring failed futures */
  def collectSuccessful[A](futures: Seq[Future[A]]): Future[Seq[A]] = ???

  /** Run f1 and f2 in parallel, returning their results in a tuple.
    *
    * NOTE: If you are using for-comprehensions and find you're having problems, try a different approach.
    *       (Not to say it can't be done with for-comprehensions, but you might not notice something using them.)
    */
  def runInParallel[A, B](f1: => Future[A], f2: => Future[B]): Future[(A, B)] = ???

  /** HARD:
    *
    * Run f in parallel over the given sequence.
    *
    * You should split the list into as many chunks as you have available processors, so that each processor can act
    * on a part of the list in parallel.
    *
    * Afterwards all the results should be concatenated together in the correct order and returned.
    *
    * Don't cheat and use Scala's in-built stuff :-P
    */
  val availableProcessors = Runtime.getRuntime.availableProcessors()

  def parallelMap[A, B](as: Seq[A])(f: A => B): Future[Seq[B]] = ???
}