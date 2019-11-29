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

  "averageGrade" should "return the average grade for a student who is in the table" in {
    assert(averageGrade("123") == Some(63.75))
  }

  it should "return None if the student is not known to the table" in {
    assert(averageGrade("456") == None)
  }

}
