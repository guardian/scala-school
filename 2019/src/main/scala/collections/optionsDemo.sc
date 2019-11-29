//Hello and welcome to this demo about Options

// Let's write a simple function that will wish someone a happy birthday

def greetSomeoneOnTheirBirthday(name: String) = s"Happy birthday, dear ${name}. Happy birthday to you!"

greetSomeoneOnTheirBirthday("Karen")

// Let's say we want to now customise this greeting if we know the person's age.
// But we will not force this issue. Maybe this person doesn't wish to share.

// We can make age an Option, because we should be able to handle when it's provided and when it isn't

val age: Option[Int] = Some(45)
val noAge: Option[Int] = None

// greetSomeoneOnTheirBirthday("Karen", Some(45))  -  we will greet Karen, who is 45 today
// greetSomeoneOnTheirBirthday("Karen", None) - we will greet Karen, who doesn't find specific age relevant

def greetSomeoneOnTheirBirthday(name: String, age: Option[Int]) = {
  //perhaps we'll talk about pattern matching in more detail later
  age match {
    case Some(age) => s"Happy birthday, dear ${name}. Happy birthday to you. Your ${age}th year is going to be fabulous."
    case None => s"Happy birthday, dear ${name}. Happy birthday to you."
  }
}

greetSomeoneOnTheirBirthday("Karen", Some(45))
greetSomeoneOnTheirBirthday("Karen", None)

//you might deal with an option like
val ageMessage = age match {
  case Some(age) => Some(s"Your ${age}th year is going to be fabulous.")
  case None => None
}

val ageMessageIfCheck = {
  if(age.isDefined) Some(s"Your ${age.get}th year is going to be fabulous.")
  else None
}