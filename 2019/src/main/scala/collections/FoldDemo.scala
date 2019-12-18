package collections

object FoldDemo {


  // we can just use numbers.length, of course, but let's do our own fold based implementation for fun
  def lengthOfAList(numbers: List[Int]): Int = ???

  // we are going to use case classes for this exercise
  // please see caseClassDemo.sc for more info

  //Suppose we have users
  case class User(
    id: String,
    name: Option[String],
    consents: List[Consent]
  )

  //And we keep track of whether what the user agreed to in terms of contacting them
  case class Consent(
    id: String,
    consented: Boolean,
    emailNewsletter: Boolean
  )

  // looks at the user's consents and counts the ones that have emailNewsletter = true
  // please use a fold
  def emailNewsletterConsentCount(user: User): Int = ???



}
