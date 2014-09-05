package com.gu.scalaschool.class2

import org.scalatest.{Matchers, FlatSpec}

class JsonWritesTest extends FlatSpec with Matchers {
  "toJson" should "serialize a boolean" in {
    JSON.toJson(true) shouldEqual JBool(true)
  }

  it should "serialize an integer" in {
    JSON.toJson(4366) shouldEqual JNumber(4366)
  }

  it should "serialize a double" in {
    JSON.toJson(43.34) shouldEqual JNumber(43.34)
  }

  it should "serialize a string" in {
    JSON.toJson("hello world") shouldEqual JString("hello world")
  }

  it should "serialize a seq for which a jsonWrites exists for the value type" in {
    JSON.toJson(Seq(1, 2, 3)) shouldEqual JArray(Seq(JNumber(1), JNumber(2), JNumber(3)))
  }

  it should "serialize a map for which a jsonWrites exists for the value type" in {
    JSON.toJson(Map(
      "hello" -> "world",
      "lucky" -> "nineteen"
    )) shouldEqual JObject(Seq(
      "hello" -> JString("world"),
      "lucky" -> JString("nineteen")
    ))
  }

  it should "serialize a Player" in {
    JSON.toJson(Player(
      "Cugel the Clever",
      Human,
      Thief,
      5,
      Seq(
        SkybreakSpatterlight
      )
    )) shouldEqual JObject(Seq(
      "name" -> JString("Cugel the Clever"),
      "race" -> JString("human"),
      "profession" -> JString("thief"),
      "goldPieces" -> JNumber(5),
      "inventory" -> JArray(Seq(
        JString("skybreakSpatterlight")
      ))
    ))
  }
}
