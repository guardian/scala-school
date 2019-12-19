// map applies a function to every item in the structure
// it's good for lists
def doubleIt(number: Int): Int = number * 2

val numbers = List(1, 2, 3, 4)
val doubleItNumbers = numbers.map(doubleIt) // it so happens that double it is a function f: Int => Int
//but the function just needs to take an integer as input if we apply it to a list of strings

def numberPositiveMessage(number: Int): String = s"$number is a great number"

val flatterNumbers = numbers.map(numberPositiveMessage)

//We can map over options and specify a function to apply if name is Some
def messageOnlyIfName(name: Option[String]) = {
  name map { name => s"Hello $name"}
}

messageOnlyIfName(Some("Carlos")) //Some(Hello Carlos)
messageOnlyIfName(None) //None

//If we need to avoid nested structures i.e. lists of lists, Option[Option[Int]] etc
//we may want to flatmap
// flatmap combines mapping, then flattening in nexted structures
val nestedNumbers = List(List(1, 2), List(3, 4))
val nestedNumbersFlattened = nestedNumbers.flatten
nestedNumbersFlattened.map(doubleIt)

val numbersDoubled = nestedNumbers.map { numberList: Seq[Int] => // map applies a function to each element and each element is a list
  numberList map { //then, for each list let's double every number in the list
    number => number * 2
  }
}

//oops, that's not what we want

numbersDoubled.flatten
//that's better

//even better:
nestedNumbers.flatMap (list => list map (number => number * 2))

//a real example of flatMap in the wild
//https://github.com/guardian/identity/blob/82ebe24cc3266c45932bad176b81058b66f2f746/identity-api/src/main/scala/com/gu/identity/api/servlet/RedirectServlet.scala#L32

// you can also use flatMap to discard Nones in a list
val strings = Seq("1", "2", "foo", "3", "bar")
val stringsAsOptions = strings.map(string => string.toIntOption)
val stringsAsInts = strings.flatMap(string => string.toIntOption)