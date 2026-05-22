# Scala School 2026

## Prerequisites

Scala runs on the JVM (Java Virtual Machine), so **you must have Java installed** on your computer in order to run Scala code.

You can install [Java](https://www.java.com/en/) in a number of different ways. Here's how you do it using `mise`:

```
$ mise install java@<version>
```
where version is the Java version you want to install.

You'll also need to download [`sbt`](https://www.scala-sbt.org/) which you can do using `mise` as well:
```
$ mise install sbt@latest
```

SBT (Scala Build Tool) is a Scala project builder. This is the tool that builds our Scala project for us.

You might need to also install [OpenJDK](https://openjdk.org).

If you want to install the Scala REPL, you can do that using mise too 
```
$ mise install scala
```
You can then run the Scala REPL by using the command
```
$ scala
```

You can find out more about how to use the Scala REPL in Lesson 2 of Get Programming With Scala by Daniela Sfregola.

## Getting started

See https://www.scala-sbt.org/1.x/docs/sbt-by-example.html for instructions on how to set up a new Scala project using SBT.

It is also possible to run a command that generates a project from scratch to speed things up. e.g.
```
$ sbt new scala/scala-seed.g8
```
which uses giter8, an sbt project generator, https://github.com/scala/scala-seed.g8.

This will generate a project structure using Scala 2. We'll be using Scala 2 throughout this course but Scala 3 is also available, with slightly different syntax in places.

The previous command will generate a project with a structure similar to this:
```
.
└── scala-seed-project/
    ├── project/
    │   ├── build.properties
    │   └── Dependencies
    ├── src/
    │   ├── main/
    │   │   └── scala/
    │   │       └── example/
    │   │           └── Hello
    │   └── test/
    │       └── scala/
    │           └── example/
    │               └── HelloSpec
    ├── .gitignore
    └── build.sbt
```

Notice how we have a `build.sbt` file at the root, a little like a `package.json` in Node.

### build.sbt

This describes how the project will be built and processed. It sets some settings and metadata for your package:
- which scala version you're using
- which version this is
- the organisation name and prefix for your package
- library dependencies to install

#### Organization

It's common in Scala to use a sort of reverse domain as your package prefix. For example if your company domain was www.example.com, the package name would be prefixed with `com.example`.

E.g. Apache (https://apache.org/) has a Scala package called Log4j. The name of the package is [`org.apache.logging.log4j`](https://mvnrepository.com/artifact/org.apache.logging.log4j) where we have reversed the domain name and used that to prefix the package name. 

The Guardian used to own the domain `gu.com` so prefixed the Scala packages with the string `com.gu`. The `gu.com` domain has since been sold but we still use this organisation prefix in our Scala packages today. See https://mvnrepository.com/search?q=com.gu

#### Dependencies

Describes which other libraries you need to install in your project.
By convention, Scala packages use `%%` whereas Java packages use `%`

For example, if we are installing the Scala `Play JSON` library, we do this by adding this to our list of dependencies:
```sbt
  // Scala
  "org.playframework" %% "play-json" % "3.0.6"
```

If we want to install a Java dependency in our Scala project, we need to use a single `%` instead of double (`%%`) e.g. AWS S3
```sbt
  // Java
  "software.amazon.awssdk" % "s3" % "2.44.4"
```

_You can learn more about SBT and how to set up a project in Lesson 3 of Get Programming With Scala by Daniela Sfregola._

### Which IDE

IntelliJ is the Guardian's recommended IDE for working with Scala.
You can also use VSCode, by installing the [Metals](https://scalameta.org/metals/docs/editors/vscode) extension.

## Basic Syntax

### Values and Variables

`TODO`

### Conditional Constructs & Loops

`TODO`

### Functions

`TODO`

## Homework

`TODO`