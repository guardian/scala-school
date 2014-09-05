package com.gu.scalaschool.class2

trait JsonWrites[A] {
  def toJson(a: A): JsonValue
}

object JsonWrites {
  implicit val boolJsonWrites = new JsonWrites[Boolean] {
    override def toJson(a: Boolean): JsonValue = JBool(a)
  }

  implicit val intJsonWrites: JsonWrites[Int] = ???

  implicit val doubleJsonWrites: JsonWrites[Double] = ???

  implicit val stringJsonWrites: JsonWrites[String] = ???

  implicit def seqJsonWrites[A](implicit jsonWrites: JsonWrites[A]): JsonWrites[Seq[A]] = ???

  implicit def mapJsonWrites[V](implicit jsonWrites: JsonWrites[V]): JsonWrites[Map[String, V]] = ???
}
