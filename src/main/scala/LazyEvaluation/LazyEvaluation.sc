// Scala uses strict evaluation by default, but allows
// lazy evaluation of value definitions with lazy val form
lazy val x = expr

// Exercise
def expr = {
  val x = { print("x"); 1 }
  lazy val y = {print("y"); 2 }
  z + y + x + z + y + x
}
expr

// Lazy Vals and Streams

// Using a lazy value for tail, Stream.cons can be implemented more efficiently:
def cons[T](hd: T, tl: => Stream[T]) = new Stream[T] {
  def head = hd
  lazy val tail = tl
}

// Seeing it in Action
(streamRange(1000,10000) filter isPrime) apply 1






















