// Sometimes we need to compute a new value based on a collection
// For example, if we needed to write a function to sum up the integers in a list
// In mutable variable land, we might do something like this
def iterativeSum(numbers: List[Int]): Int = {
  var sumSoFar = 0
  for(i<-0 to numbers.length){
    sumSoFar = sumSoFar + i
  }

  sumSoFar
}

iterativeSum(List(1, 2, 3))

// But we don't use mutable variables, to make our code easier to reason about
// We might do a recursive implementation like this
def sum(numbers: List[Int]): Int = {
  numbers match {
    case Nil => 0
    case x :: Nil => x
    case x :: xs => x + sum(xs)
  }
}

sum(List(1, 2, 3)) //still gives the right answer

// But more commonly we would use a fold
// We can use folds to combine elements of a list using a function we pass to the fold
// We pass to a fold
// 1) an initial value which could be returned if we were folding over an empty list
// E.g. for a sum function we'd pass 0. No elements have a sum of 0.
// 2) a function that takes the next element of the list and an accumulator that is the combined value so far

// foldLeft simply iterates over the list from left to right
def foldLeftSum(numbers: List[Int]): Int = {
  numbers.foldLeft(0){ (acc, next) =>
    println(s"foldLeft: combining $next with our accumulator $acc")
    acc + next
  }
}

foldLeftSum(List(1, 2, 3))

// foldRight simply iterates over the list from right to left
def foldRightSum(numbers: List[Int]): Int = {
  numbers.foldRight(0){ (next, acc) => //note the order of the arguments have reversed
    println(s"foldRight: $next with our accumulator $acc")
    acc + next
  }
}

foldRightSum(List(1, 2, 3))

// doesn't guarantee an order
// fine for a sum
def foldSum(numbers: List[Int]): Int = {
  numbers.fold(0){ (next, acc) => //note the order of the arguments have reversed
    println(s"fold: combining $next with our accumulator $acc")
    acc + next
  }
}

foldSum(List(1, 2, 3))


// there is a nice blog post on folds here https://commitlogs.com/2016/09/10/scala-fold-foldleft-and-foldright/