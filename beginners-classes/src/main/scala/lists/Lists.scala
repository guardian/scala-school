package lists

object Lists {

  // Constructing Lists

  // Construct a simple list of Int
  // Note the type paramater in [], specifying that this List is of type Int.
  val ints : List[Int] = List(1, 2, 3)

  // This time we have a list of Strings
  val strings: List[String] = List("one", "two", "three")

  // Lets add an element to the start of the List using :: (pronounced 'cons')
  // Note, we have not changed ints! We have crreated a new list zeroInts.
  // Scala Lists are IMMUTABLE
  val zeroInts = 0 :: ints

  // Nil is a special case of List. it is essentially a list with no elements
  val emptyList = Nil

  // We can use :: and Nil to construct a new List too!
  val chars = 'a' :: 'b' :: 'c' :: Nil


  // Useful List methods
  // size - the number of elements in a list
  // head - the first element in a list
  // apply(Int) - returns the ith element in a list

  /**
   * Returns the bigger of two lists
   * @param l1 an arbitrary list
   * @param l2 another arbitrary list
   * @tparam A the type of the elements in both lists (e.g. Int, String, Boolean, etc)
   * @return the biggest of l1 and l2
   */
  def max[A](l1: List[A], l2: List[A]): List[A] = if(l1.size >= l2.size) l1 else l2

  def min[A](l1: List[A], l2: List[A]): List[A] = ???

  /**
   * Returns the first element of the list as a String
   * @param list an arbitrary list
   * @return the first element of the list as a String
   */
  def headString(list: List[_]): String = list.head.toString

  /**
   * Compares the first element of 2 lists and decides if they are equal or not.
   * Note, equality can be determined by using <code>a == b<code>
   */
  def headsEqual(l1: List[_], l2: List[_]): Boolean = ???

  /**
   * Returns the string value of the ith element of the list. Note the list is zero-indexed.
   */
  def getStringAt(list: List[_], i: Int): String = {
    val elem = list(i) // Note this is shorthand for list.apply(i)
    elem.toString
  }

  /**
   * Compares the ith element of 2 lists and decides if they are equal or not.
   * Note, equality can be determined by using <code>a == b<code>
   */
  def isEqual(l1: List[_], l2: List[_], i: Int): Boolean = ???

  // Ways of traversing and transforming a list
  // map[A, B](A => B) - converts a list into a different list using the provided function
  // filter[A](A => Boolean) - removes elements from a list if they don't match a specific predicate
  // take(Int) - returns the first i elements of a list
  // drop(Int) - returns the last i elements of a list
  // takeWhile[A](A => Boolean) - returns elements of a list until it reaches an element that does not satisfy the predicate
  // reverse -  reverses the order of a list
  // foreach - performs some side efect on each element in a list. THIS IS NOT FUNCTIONAL!

  def ints2Strings(list: List[Int]): List[String] = {
    def intString(i: Int): String = i.toString
    ints.map(intString) // Note we are referencing the function intString as a parameter here. map is a higher order function!
  }

  // TODO implement the 'times' function that multiplies each element in a List[Int] by some parameter i.
  // E.g. times(List(1, 2, 3), 5) should return List(5, 10, 15)
  def times(l: List[Int], i: Int): List[Int] = ???

  def evens(list: List[Int]): List[Int] = {
    def isEven(i: Int): Boolean = i % 2 == 0
    list filter isEven // Same as list.filter(isEven)
  }

  /**
   * Removes all strings whose length is greater than <code>length<code>
   *   Note String.length returns the length of a string.
   */
  def shortStrings(strings: List[String], length: Int): List[String] = ???

  // Recursion
  // tail - returns the list with the head removed
  // Use isEmpty or list == Nil to terminate a list
  // fold[A, Z](Z)((Z, A) => Z) - can be used in place of recursion

  /**
   * Recursively 'walks' the list of Ints adding them up to calculate the sum.
   * @return the sum of the list elements
   */
  def sum(list: List[Int]): Int ={
    if(list.isEmpty)
      0
    else list.head + sum(list.tail)
  }

  /**
   * Recursively 'walks' the list of Ints multiplying them together to calculate the product.
   * @return the product of the list elements
   */
  def product(list: List[Int]): Int = ???

  // Hard!
  /**
   * Finds the largest value in a list of Ints
   */
  def maxValue(list: List[Int]): Int = ???

  /**
   * Calculate the sum of a list of Ints using foldLeft
   */
  def foldSum(list: List[Int]): Int ={
    list.foldLeft(0){ case (total, i) => total + i}
  }

}
