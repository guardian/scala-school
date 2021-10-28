package lists

import org.scalatest._

class ListsTest extends FlatSpec with Matchers{

  "Lists" should "have pre-constructed lists" in {
    Lists.ints should be(List(1, 2, 3))

    Lists.strings should be(List("one", "two", "three"))

    Lists.chars should be(List('a', 'b', 'c'))
  }

  it should "identify the bigger of two lists" in {
    Lists.max(Lists.ints, Lists.zeroInts) should be(Lists.zeroInts)
    Lists.max(Lists.zeroInts, Lists.ints) should be(Lists.zeroInts)
  }

  it should "identify the smallest of two lists" in {
    Lists.min(Lists.ints, Lists.zeroInts) should be(Lists.ints)
    Lists.min(Lists.zeroInts, Lists.ints) should be(Lists.ints)
  }

  it should "compare the first element of 2 lists" in {
    import Lists._

    headsEqual(ints, zeroInts) should be(false)
    headsEqual(ints, chars) should be(false)
    headsEqual(ints, ints) should be(true)
    headsEqual(chars, chars) should be(true)
    headsEqual(ints, List(1)) should be(true)
  }

  it should "compare the ith element of 2 lists" in {
    import Lists._

    isEqual(ints, chars, 1) should be(false)
    isEqual(ints, ints, 1) should be(true)
    isEqual(chars, chars, 1) should be(true)
    isEqual(ints, List(0, 2), 0) should be(false)
    isEqual(ints, List(0, 2), 1) should be(true)
  }

  it should "convert lists of Ints into Strings" in{
    import Lists._
    ints2Strings(ints) should be(List("1", "2", "3"))
    ints2Strings(zeroInts) should be(List("0", "1", "2", "3"))
  }

  it should "multiply all elements in a list by an arbitrary Int" in {
    import Lists._
    //    times(ints, 5) should be(5, 10, 15)
    //    times(zeroInts, 2) should be(0, 2, 4, 6)
  }

  it should "filter out Strings above a certain length" in {
    import Lists._

    shortStrings(strings, 3) should be(List("one", "two"))
    shortStrings(List("Goodbye", "cruel", "world"), 5) should be(List("cruel", "world"))
  }

  it should "sum the values of a list of Ints" in {
    import Lists._

    sum(ints) should be(6)
    sum(zeroInts) should be(6)
    sum(Nil) should be(0)
    sum(List(-1, 5, 3)) should be(7)
  }

  it should "calculate the product of the values of a list of Ints" in {
    import Lists._

    product(ints) should be(6)
    product(zeroInts) should be(0)
    product(Nil) should be(1)
    product(List(-1, 5, 3)) should be(-15)
  }

  it should "find the largest value in a list of Ints" in {
    import Lists._

    maxValue(ints) should be(3)
    maxValue(zeroInts) should be(3)
    maxValue(List(-1, 5, 3)) should be(5)
    maxValue(List(1, -5, 3)) should be(3)

    //maxValue(Nil) should be(???) What should this be?
  }

  it should "sum the values of a list of Ints using fold" in {
    import Lists._

    foldSum(ints) should be(6)
    foldSum(zeroInts) should be(6)
    foldSum(Nil) should be(0)
    foldSum(List(-1, 5, 3)) should be(7)
  }

}
