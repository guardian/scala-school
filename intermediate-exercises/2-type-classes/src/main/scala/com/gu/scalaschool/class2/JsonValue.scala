package com.gu.scalaschool.class2

sealed trait JsonValue

case class JString(get: String) extends JsonValue

case class JNumber(get: Double) extends JsonValue

case class JBool(get: Boolean) extends JsonValue

case class JArray(get: Seq[JsonValue]) extends JsonValue

case class JObject(get: Seq[(String, JsonValue)]) extends JsonValue

object JSON {
  /** Turn jsonValue into a compact String (no unnecessary whitespace) */
  def stringify(jsonValue: JsonValue): String = ???

  def toJson[A](a: A)(implicit writes: JsonWrites[A]): JsonValue =
    writes.toJson(a)
}
