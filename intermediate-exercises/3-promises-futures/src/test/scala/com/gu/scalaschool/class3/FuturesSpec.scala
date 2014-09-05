package com.gu.scalaschool.class3

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Span}
import org.scalatest.{Matchers, FlatSpec}

import scala.concurrent.{Future, blocking}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class FuturesSpec extends FlatSpec with Matchers with ScalaFutures {
  object WernerHerzog

  "extractTry" should "wrap successful futures in a Success" in {
    futures.extractTry(Future.successful(WernerHerzog)).futureValue should be(Success(WernerHerzog))
  }

  it should "catch errors and wrap them in a Failure" in {
    val darn = new RuntimeException("Darn")
    futures.extractTry(Future.failed(darn)).futureValue should be(Failure(darn))
  }

  "inParallel" should "run the provided futures in parallel" in {
    def slowNumber(n: Int) = Future {
      blocking {
        Thread.sleep(100)
        n
      }
    }

    val r = futures.runInParallel(slowNumber(1), slowNumber(2))

    assert(r.isReadyWithin(Span(110, Millis)), "Did not complete quickly enough - are these REALLY in parallel?")
    r.futureValue should be((1, 2))
  }

  "collectSuccessful" should "collect the futures that succeed" in {
    futures.collectSuccessful(Seq(
      Future.successful(1),
      Future.failed(new RuntimeException("oops")),
      Future.successful(1),
      Future.successful(2),
      Future.failed(new RuntimeException("oops")),
      Future.successful(3)
    )).futureValue should be(Seq(1, 1, 2, 3))
  }

  "parallelMap" should "parallelize over available processors" in {
    val availableProcessors = Runtime.getRuntime.availableProcessors()

    val units = List.fill(availableProcessors)(())

    val results = futures.parallelMap(units) { _ =>
      blocking {
        Thread.sleep(100)
        WernerHerzog
      }
    }

    assert(results.isReadyWithin(Span(110, Millis)))
    results.futureValue should be(List.fill(availableProcessors)(WernerHerzog))
  }
}
