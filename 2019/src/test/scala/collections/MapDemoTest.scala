package collections

import org.scalatest.FlatSpec
import MapDemo._

class MapDemoTest extends FlatSpec {

  "squarer" should "square every element in a list" in {
    val numbers = List(1, 2, 3)
    assert(squarer(numbers) == List(1, 4, 9))
  }

  it should "do nothing if the list is Nil" in {
    assert(squarer(Nil) === Nil)
  }

}
