package collections

import org.scalatest.FlatSpec
import OptionsDemo._

class OptionsDemoTest extends FlatSpec {

  "userHasUpdatedProfile" should "return false if both names are None" in {
    assert(userHasUpdatedProfile("12345", None, None) == false)
  }

  it should "return true if both names have values" in {
    assert(userHasUpdatedProfile("12345", Some("jo"), Some("bloggs")) == true)
  }

  it should "return true if one of the names has a values" in {
    assert(userHasUpdatedProfile("12345", Some("jo"), None) == true)
  }

}
