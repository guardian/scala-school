package com.gu.scalaschool.class2

import org.scalatest.{Matchers, FlatSpec}

class JsonValueTest extends FlatSpec with Matchers {
  "JSON.stringify" should "properly serialize a JBool(true)" in {
    JSON.stringify(JBool(true)) shouldEqual "true"
  }

  it should "properly serialize a JBool(false)" in {
    JSON.stringify(JBool(false)) shouldEqual "false"
  }

  it should "properly serialize a JNumber" in {
    JSON.stringify(JNumber(10)) shouldEqual "10"
    JSON.stringify(JNumber(3.5)) shouldEqual "3.5"
  }

  it should "properly serialize a JString" in {
    JSON.stringify(JString("Hello")) shouldEqual "\"hello\""
    JSON.stringify(JString("""I said, "hello"!""")) shouldEqual """"I said, \"hello\"!""""
  }

  it should "properly serialize a JArray" in {
    JSON.stringify(JArray(Seq(
      JNumber(10),
      JBool(false),
      JString("hey")
    ))) shouldEqual """[10,false,"hey"]"""
  }

  it should "properly serialize a JObject" in {
    JSON.stringify(JObject(Seq(
      "hello" -> JString("world"),
      "lucky" -> JNumber(19)
    ))) shouldEqual """{"hello":"world","lucky":19}"""
  }
}
