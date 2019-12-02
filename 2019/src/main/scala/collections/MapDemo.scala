package collections

object MapDemo {

  //for when you need to square every element in a list
  def squarer(numbers: List[Int]): List[Int] = ???

  val studentResults = Map[String, List[Double]](
    "123" -> List(57, 50, 70, 78),
    "124" -> List(60, 60, 51),
    "125" -> List(55, 57, 78)
  )

  //note:
  //scala> List(1, 2, 3).sum
  //res38: Int = 6

  def averageGrade(studentId: String): Option[Double] = ???


}
