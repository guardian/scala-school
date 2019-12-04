package collections

object CollectionsDemo {

  val studentResults = Map[String, List[Double]](
    "123" -> List(57, 50, 70, 78),
    "124" -> List(60, 60, 51),
    "125" -> List(55, 57, 78)
  )



  //for when you want that student's average grade, if we can find them in the map
  def averageGrade(studentId: String): Option[Double] = ???
  //note:
  //scala> List(1, 2, 3).sum
  //res38: Int = 6

}
