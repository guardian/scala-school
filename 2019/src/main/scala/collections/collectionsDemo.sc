// Commonly used collections

// Lists
// * preserve order
// * can contain duplicates
// * are immutable
// * are implemented as linked list
// Try some exercises here: https://www.scala-exercises.org/std_lib/lists

// Lists are often thought about in terms of head and tail
val numbers = List(1, 2, 3)
println(s"head: ${numbers.head}") // should be 1
println(s"tail: ${numbers.tail}")// should be List(2, 3)

// you can add elements to a list by appending to the list as the head
val zeroIndexedNumbers = 0 :: numbers

// Let's create a list
val favouriteRailStations: List[String] = List("Euston", "Kings Cross", "Moorgate", "Blackfriars")

// An empty list is Nil
val emptyList = Nil

// Euston is dead to me
// favouriteRailStations(0) = "Marylebone"

// oops, doesn't compile because Lists are immutable
// I still want the other stations
val stationsMinusEuston = favouriteRailStations.tail

// these are my favourites
val topLondonRailStationsIn2019 = "Marylebone" :: stationsMinusEuston

//we may often wish to apply a function to a list
def londonise(station: String): String = s"London ${station}"

// not all of my favourite stations are in London
// map applies a function to every element in this list. More later.
val londonStations = topLondonRailStationsIn2019.map(londonise)
val topStations = "Glasgow Queen Street" :: "Fishguard Harbour" :: "Glasgow Central" :: londonStations

// we can apply filters to lists
val glasgowStations = topStations.filter(station => station.startsWith("Glasgow"))

//when you use lists pick the head
val firstStation = topStations.head // just picks the first item

//but you'll need to ask for head as an option
//because you might not get an element back if your list is Nil

// Options
// * are not a collection
// * but are relevant to collections, when you request an item from a collection that might not be there

// topStations.headOption will return Some("Glasgow Queen Street") because the list did have a head
// Nil.headOption will return None because the list is empty

// but actually use headOption, because you might not get an element back if your list is Nil
val firstStationOption = topStations.headOption

firstStationOption map { station =>
  println(s"There was a station in the list, and it was $station")
}

//throws an error
//println(s"There was a station in the list, and it was ${emptyList.head}")

// just doesn't print
emptyList.headOption map { station =>
  println(s"There was a station in the list, and it was $station")
}

// you can access items in a list by index
val secondStation = topStations(1)

// but just because you can, doesn't mean you should
val lastStation = topStations(topStations.length - 1) //gets the last element, but checks every element in the list

// Vectors
// * preserve order
// * can contain duplicates
// * are immutable
// * are implemented in a way to be better at random access

//vectors are implemented so that random access is nearly as fast as just plucking the first element
val topStationsVector = topStations.toVector
val lastStationSpeedier = topStationsVector(topStations.length - 1)

//use vectors if you know you need random access, otherwise use lists.

// Sets
// * do not care about order
// * cannot contain duplicates
// * are immutable
// So, sets in Scala work like mathematical sets
// Try some exercises here: https://www.scala-exercises.org/std_lib/sets
val validMethods = Set("GET", "GET", "POST")
println(validMethods) // will print Set(GET, POST)
//shows we don't care about order
val methodToCheck = "DELETE"
val isAllowed = validMethods.contains(methodToCheck)


// Maps
// * are immutable
// * can hold a key/value pair
// Try some exercises here: https://www.scala-exercises.org/std_lib/maps
val provincesAndTerritories = Map(
  "BC" -> "British Columbia",
  "AB" -> "Alberta",
  "MB" -> "Manitoba",
  "SK" -> "Saskatchewan",
  "ON" -> "Ontario",
  "QC" -> "Quebec",
  "NL" -> "Newfoundland",
  "NS" -> "Nova Scotia",
  "PE" -> "Prince Edward Island",
  "YK" -> "Yukon Territory",
  "NT" -> "Northwest Territories"
)

val longNameForQC = provincesAndTerritories("QC")

def greetACanadian(provinceCode: String): String = {
  s"Hi there friend! I see you have come from ${provincesAndTerritories(provinceCode)}"
}

println(greetACanadian("MB"))

//but you might try to access an element in the map that doesn't exist
// println(greetACanadian("AA")) will throw a java.util.NoSuchElementException

def greetACanadianMoreSafely(provinceCode: String): String = {
  provincesAndTerritories.get(provinceCode) match {
    case Some(longerName) => s"Hi there friend! I see you have come from $longerName"
    case None => "Hi there friend! I don't recognise the province you gave me, but welcome anyway!"
  }
}

greetACanadianMoreSafely("BLAH")