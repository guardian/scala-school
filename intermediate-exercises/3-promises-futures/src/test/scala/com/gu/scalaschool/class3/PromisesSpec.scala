package com.gu.scalaschool.class3

import java.util.concurrent.{TimeUnit, Future}

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, FlatSpec}
import promises._

class PromisesSpec extends FlatSpec with Matchers with ScalaFutures {
  "requestWhizzBangWallopFuture" should "return a failed Future on an error" in {
    val shucks = new RuntimeException("shucks!")

    val whizzBang = new EnterpriseWhizzBangWallopService {
      override def requestWhizzBangWallop(handler: AsyncHandler[WhizzBangWallop]): Future[WhizzBangWallop] = {
        handler.onError(shucks)

        new Future[WhizzBangWallop] {
          override def isCancelled: Boolean = true

          override def get(): WhizzBangWallop = throw shucks

          override def get(timeout: Long, unit: TimeUnit): WhizzBangWallop = throw shucks

          override def cancel(mayInterruptIfRunning: Boolean): Boolean = true

          override def isDone: Boolean = false
        }
      }
    }

    intercept[RuntimeException] {
      whizzBang.requestWhizzBangWallopFuture.futureValue
    }
  }

  it should "return a completed Future if successful" in {
    val whizzBang = new WhizzBangWallop {}

    val whizzBangService = new EnterpriseWhizzBangWallopService {
      override def requestWhizzBangWallop(handler: AsyncHandler[WhizzBangWallop]): Future[WhizzBangWallop] = {
        handler.onSuccess(whizzBang)

        new Future[WhizzBangWallop] {
          override def cancel(mayInterruptIfRunning: Boolean): Boolean = false

          override def isCancelled: Boolean = false

          override def get(): WhizzBangWallop = whizzBang

          override def get(timeout: Long, unit: TimeUnit): WhizzBangWallop = whizzBang

          override def isDone: Boolean = true
        }
      }
    }

    whizzBangService.requestWhizzBangWallopFuture.futureValue should be(whizzBang)
  }
}
