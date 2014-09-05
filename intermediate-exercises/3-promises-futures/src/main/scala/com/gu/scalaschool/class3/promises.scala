package com.gu.scalaschool.class3

import scala.concurrent.{Promise, Future}

object promises {
  /** Sometimes in the "real world" away from all this "ivory tower functional programming" you have to wrap Java
    * libraries.
    *
    * They might even be Java Enterprise libraries.
    * But we hope not.
    *
    * Java's concurrency model is quite different to Scala's. You don't need to worry too much about how it works, but
    * Java Futures do not provide the same functionality. You can't map over Java Futures, or register callbacks that
    * are triggered when they complete. All you can really do is check if they have completed, or block the current
    * thread to wait for the Future to complete.
    *
    * Java libraries do, however, sometimes allow you to register callbacks as well as creating a Java Future. We can
    * use these to conveniently create Scala Futures, through the use of promises.
    */
  implicit class RichEnterpriseWhizzBangWallopService(service: EnterpriseWhizzBangWallopService) {
    def requestWhizzBangWallopFuture: Future[WhizzBangWallop] = ???
  }
}
