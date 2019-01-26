# Clojure beginners workshop - planning

## Name tags

When people enter, they can fill out a name tag, either:

* Red means "I want to teach"

* Blue means "I want to learn"

## Potential topics for discussion

* Installation/setup

* The REPL

* Language basics (Lisp syntax, defining values and functions)

* Java inter-op

* Functional programming

* Macros

* Concurrent / parallel programming

* Text editor integration

## If I'm the only teacher...

It looks like almost everyone who's RSVP'd so far says they're a beginner. That
means this meetup might just be me leading the entire group! Which I'd be OK
with, but it does mean that I should probably plan a rough course.

### Rough course outline

#### Installation / setup

* clojure.org => "Get started," install clojure CLI tools

* It looks like the clojure CLI tools aren't available for Windows. So if
  anybody is using Windows, can maybe have them use Boot instead. It looks like
  maybe the easiest way to install Boot for Windows users (given that I know
  nothing about the Windows PATH) would be to install Chocolatey, then run
  `choco install boot-clj`. (Instructions / link in the Boot repo.)

  * Another option is Nightcode: https://sekao.net/nightcode/

    Just a .exe download away from a full Clojure dev environment.

* And there's also repl.it, which is a nice-looking environment where you can
  have files and a REPL, all within your browser.

  I think repl.it will be great option for anybody who is struggling to install
  Clojure on their machine.

  They can go to repl.it, don't have to sign in, just scroll to the bottom where
  there is a list of languages, and click the Clojure link.

#### The REPL

Once everyone is set up, explain what a REPL is, how to get to one, and make
sure everyone can get to the point where they can evaluate `(+ 1 1)` and get
`2`.

#### Language basics

> From here onward, we'll be working up to coding up a vending machine example.
>
> Can go through the example later on in more detail, but can at least allude to
> some things from the example here when going over the basics. For example, if
> doing the vending machine example, can demonstrate functions by defining one
> called `amount-enough?` that takes a money amount and returns whether it's
> enough for the price of an item in the vending machine.

##### Lisp syntax

Explain all the primitive types, type each of them into the REPL, maybe with
examples like adding numbers together, uppercasing a string, etc.

##### Defining values

Explain `def`, use it at the REPL.

##### Defining functions

Explain `defn`, use it at the REPL.

##### Java inter-op

Can demonstrate using String methods, Integer/parseInt, etc.

#### Functional programming

Let the vending machine example guide this part. Explain how the goal is to
write pure functions that take data in one form and return data in another form,
and then compose them together.

As an example, maybe whip up an imperative Ruby/Java example of a vending
machine where there is a VendingMachine class and you create an instance of it
and then run methods on it that mutate its state.

The exercise from here onward is to reproduce this in Clojure, using functional
programming techniques.

Can start by explaining state machines and whiteboarding out the possible states
our vending machine could have.

#### If there is still time left...

* Concurrency (`future`, `pmap`, etc.)

* Dependencies (e.g. can use alda-clj to demonstrate!)

* Build tools (Leiningen, Boot)

* Macros

* clojure.spec

