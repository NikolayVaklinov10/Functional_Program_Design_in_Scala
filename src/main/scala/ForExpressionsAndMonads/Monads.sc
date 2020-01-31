//Monads are not nether classes  or traits they are data structure

// They consists flatMap() and unit() methods

// What is Monad?
// A Monad M is a parametric type M[A] with two operations, flatMap and unit, that
// have to satisfy some laws.

trait M[T]{
  def flatMap[U](f: T => M[U]): M[U]
}
def unit[T](x: T): M[T]

// Examples of Monads

// List is a monad with unit(x) = List(x)
// Set is a monad with unit(x) = Set(x)
// Option is a monad with unit(x)  = Some(x)
// Generator is a monad with unit(x) = single(x)

// flatMap is an operation on each of these types, whereas unit in Scala is
// different for each monad

// Monads and map

// map can be defined for every monad as a combination of flatMap and unit:

// m map f == m flatMap (x => unit(f(x)))
//         == m flatMap (f andThen unit)


// Monad Laws

// To qualify as a monad, a type has to satisfy three laws:
// Associativity:

// m flatMap f flatMap g == m flatMap (x => f(x) flatMap g)

// Left unit

// unit(x) flatMap f == f(x)

// Right unit

// m flatMap unit == m


// Checking Monad Laws
// Let's check the monad laws for Option.
// Here's flatMap for Option

abstract class Option[+T]{
  def flatMap[U](f: T => Option[U]): Option[U] = this match {
    case Some(x) => f(x)
    case None => None
  }
}

// Checking the left Unit Law
// Need to show: Some(x) flatMap f == f(x)
// Some(x) flatMap f

// Some(x) match {
// case Some(x) => f(x)
// case None => None
// }


// Checking the Right Unit Law
// Need to show: opt flatMap Some == opt

// opt flatMap Some

// opt match {
// case Some(x) => Some(x)
// case None => None
// }


// Checking the Associative Law
// Need to show: opt flatMap f flatMap g == opt flatMap (x => f(x)
// flatMap g)

// opt flatMap f flatMap g




















