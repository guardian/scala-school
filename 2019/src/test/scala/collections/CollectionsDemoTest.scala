package collections

import org.scalatest.FlatSpec
import CollectionsDemo._

class CollectionsDemoTest extends FlatSpec {

  "averageGrade" should "return the average grade for a student who is in the table" in {
    assert(averageGrade("123") == Some(63.75))
  }

  it should "return None if the student is not known to the table" in {
    assert(averageGrade("456") == None)
  }

}
