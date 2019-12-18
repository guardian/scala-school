//Case classes are good for modelling your immutable data
// https://docs.scala-lang.org/tour/case-classes.html
//

// We could for example, create a model of a user
case class User(
  id: String,
  name: Option[String],
  isContributor: Boolean
)

//we can create instances of users like this
val user1 = User(
  id = "123",
  name = None,
  isContributor = false
)

val user2 = User(
  id = "124",
  name = Some("Gladys West"),
  isContributor = true
)

val sameAsUser2 = User(
  id = "124",
  name = Some("Gladys West"),
  isContributor = true
)

user1 == user2 //not the same
user2 == sameAsUser2 //they have the same structure, so they are equal

//When we create an instance of a case class, that instance is immutable. If user1 becomes a contributor
//We can use copy
val user1Contributor = user1.copy(isContributor = true) //the same as user1, but isContributor is now true
