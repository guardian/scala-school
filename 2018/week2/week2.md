# Introduction

During the session this week we will aim to explore the following
subjects:

+ The difference between compile-time and run-time
+ Introduction to "Typed" programming
+ Built-in types
+ Custom types
+ Exercise: modelling data with Classes

We will then build on this to create a simple program that models the
results from an API using the Scala data model.

# The compiler

In order to execute your code, it needs to be some how converted from
the text files you create into a format that is executable by the
machine (in the case of Scala this is Java byte-code which can be
executed by a special program, the JVM).

But it also does much more than that: while it is processing your code
in order to do this conversion, it has the opportunity to do all kinds
of checking and validation, and there are many classes of error which
it is able to warn you about before you ship your program.

## Variable definition

For example, consider this Javascript code:

```javascript
var person = { name: "CP Scott" }
console.log(peron.name)
```

Javascript is not, by default, a compiled language, and so assuming
you have not spotted it with the naked eye, the only way to identify
the error in this code is to run it.

On the other hand, the Scala compiler is able to enforce the simple
rule that the variables that you refer to need to be defined in
advance, to ensure that you are referring to the variable you thought
you were. In Scala, we might see:

```scala
val person = Map("name" -> "CP Scott")
println(peron("name"))
```

If you attempt to compile this, then *before* you even run it, you
will get an error message, something like the following:

```
cmd0.sc:2: not found: value peron
val res0_1 = println(peron("name"))
                     ^
Compilation Failed
```

This is of course a trivial example, but we can imagine how this might
work in a significantly larger code base.

## The Scala Compiler

Some compilers are very lightweight and lenient: they don't add much
functionality other than translation, and they don't do much
checking. The Scala compiler on the other hand, is of the opposite
variety: it is a complicated and powerful beast.

It consists of a number of different "compiler phases" during which it
does all kinds of sophisticated manipulation of your code before the
final phase where makes it runnable.

For example, one of the things that the compiler can do is apply a set
of "suguring" rules which are really just syntactic shortcuts that
make it easier to write code. The compiler takes this shorthand code
and ultimately modifies to into the same long hand code that you might
otherwise have written.

There is no need to understand or deal with the complexities of the
Scala compiler at this stage, but it might be worth keeping this
characterisation of the compiler in mind as we go forward, as it will
help you to understand what role the compiler is playing and how it
differs not just from non-compiled languages, but also from some other
compiled languages that you may be familiar with.

## Types

Types are subsets from all the possible values that a piece of data can
have. For example, the type `Byte` defines the set of signed numbers
that can be represented by 8 bits. `7` is a member of this set
therefore, because it can be represented by 3 bits. 300 however is
not, because it requires 9 bits.

Type declarations are simply a way to tell the compiler that the data
assigned to a given value is limited to that subset.

A significant difference between Scala and other (non-typed) languages
such as Python or JavaScript is that once a piece of data has been
assigned a type, it cannot be changed:

```scala
var i = 10 // i now has type Int
i = 100    // this is ok because 100 is included in the type Int
i = "foo"  // this is a compile time error
```

```
cmd2.sc:3: type mismatch;
 found   : String("foo")
 required: Int
val res2_2 = i = "foo"
                 ^
Compilation Failed
```

However, if this seems like a limitation, remember two things:

1. The compiler uses this to give you a lot of information and error
   checking which is invaluable on larger projects
2. Scala has an extremely flexible and expressive type system, so you
   can almost always achieve what you want in a 'type-safe' way

## Custom types

In addition to these built in types, Scala also allows you to define
your own types, and in so doing, defining the data that can be
associated with them and the operations that can be be performed on
them. In addition you can define relationships between types, which
tell the compiler that, for example, when you are expecting a value of
type A, it is ok to receive one of type B, because type B has all of
the qualities of A (although it may also have more).

One of the kinds of custom types in scala is the "Class":

```scala
class Dog(val name: String) {
   def speak = "woof"
}
```

Now if we want to say that we can operate not just on dogs, but on any
type that has a valid `speak` method available for it, then we can
define that behaviour as a `trait` (this is not the only way to do
this, but it is a simple way to get started):

```scala
trait TalkativeAnimal {
  def speak: String
}
```

Note that this trait doesn't define the *implementation* of this
operation, nor what the actual result will be, it merely defines that
the operation *exists*, and that the value it will return will be of
the subset `String` (a set of text characters).

We can now declare to the compiler that a `Dog` has this specific
behaviour, and the compiler will then know that where we are expecting
a `TalkativeAnimal`, it is ok to receive a `Dog`.

Note that one of the many checks that the compiler performs will come
into play here, as it will confirm that we have actually defined the
behaviour that we say we have. If, for example, we had a definition of
`Dog` that looked like the following:

```scala
class Dog(val name: String) extends TalkativeAnimal {
    def sleep = "zzz"
}
```

it would not compile:

```
cmd4.sc:4: class Dog needs to be abstract, since method speak in trait TalkativeAnimal of type => String is not defined
class Dog(val name: String) extends TalkativeAnimal {
      ^
Compilation Failed
```

## Modelling data with Classes

