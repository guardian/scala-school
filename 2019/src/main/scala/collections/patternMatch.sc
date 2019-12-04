import org.joda.time.DateTime
//pattern matching = checking a value against a pattern


def isThereCurryToday: Boolean = {
  val today = DateTime.now()
  val dayOfWeek: Int = today.getDayOfWeek //0 = Sunday

  // we can use it to transform the day of the week to yes/no
  dayOfWeek match {
    case 4 => true
    case _ => false // case _ represents any other integer value
  }
}

isThereCurryToday


def myAge(age: Option[Int]): String = {
  //you need an exhaustive match
  age match {
    case Some(age) if age == 1=> s"Why, I am $age year of age."
    case Some(age) => s"Why, I am $age years of age."
    case None => "That's none of your business!"
  }
}

myAge(Some(0))
myAge(Some(1))
myAge(Some(-1))
myAge(None)