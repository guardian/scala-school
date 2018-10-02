# Introduction

During the session this week we will aim to explore the following
subjects:

+ The difference between compile-time and run-time
+ Introduction to "Typed" programming
+ Built-in types
+ Custom types

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

## Variable definitition

For example, consider this example Javascript code:

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

If you attempt to compile this, *before* you even run it, you will get
an error message, something like the following:

```
Compiling /tmp/ammoniteAYPcXm.sc
ammoniteAYPcXm.sc:3: not found: value peron
val res_1 = println(peron("name"))
                    ^
Compilation Failed
```

This is of course a trivial example. Imagine this in a significantly
larger code base.

## The Scala Compiler

Some compilers are very lightweight and lenient: they don't add much
functionality other than translation, and they don't do much
checking. The Scala compiler on the other hand, is of the opposite
variety: it is a complicated and powerful beast.

It consists of a number of different "compiler phases" during which it
does all kinds of sophisticated manipulation of your code before the
final phase where makes it runnable. Here are just some of the things
the scala comiler can do for you:

For example, one of the things that the compiler can do is apply a set
of "suguring" which are really just syntactic shortcuts that make it
easier to write code, but which ultimately get modified by the
compiler into the same long hand code that you might otherwise have
written.

```
@ desugar { for(i <- nums; if i % 2 == 0) println(i) }
res4: Desugared = ammonite.$sess.cmd2.nums.withFilter(((i: Int) => i.%(2).==(0))).foreach[Unit](((i: Int) => scala.Predef.println(i)))
```

There is no need to understand or deal with the complexities of the
Scala compiler at this stage, but it might be worth keeping this
charecterisation of the compiler in mind as we go forward, as it will
help you to understand what role the compiler is playing and how it
differs not just from non-compiled languages, but also from some other
compiled languages that you may be familiar with.
