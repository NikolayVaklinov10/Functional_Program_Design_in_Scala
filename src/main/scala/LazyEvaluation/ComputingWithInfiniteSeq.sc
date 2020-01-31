import scala.collection.immutable.LazyList


// Infinite Streams
def from(n:Int): Stream[Int] = n #:: from(n+1)

// The Sieve of Eratosthenes in Code
def sieve(s: Stream[Int]): Stream[Int] =
// #:: is Stream.cons(x, xs)
  s.head #:: sieve(s.tail filter (_ % s.head != 0))

val primes = sieve(from(2))



























