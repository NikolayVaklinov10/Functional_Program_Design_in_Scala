// Collections and Combinatorial Search

// Find the second prime number between 1,000 and 10,000
((1000 to 10000) filter isPrime)(1)


// The much longer recursive version
def secondPrime(from:Int, to:Int) = nthPrime(from, to, 2)
def nthPrime(from:Int, to:Int,n:Int):Int =
  if (from >= to) throw new Error("no prime")
else if (isPrime(from))
    if (n == 1) from else nthPrime(from + 1, to, n - 1)
else nthPrime(from + 1, to, n)



// Implementation of Streams

trait Stream[+A] extends Seq[A]{
  def isEmpty: Boolean
  def head: A
  def tail: Stream[A]
}

// Implementation of Streams-2
object Stream{
  def cons[T](hd: T, tl: => Stream[T]) = new Stream[T]{
    def isEmpty = false
    def head = hd
    def tail = tl
  }
  val empty = new Stream[Nothing]{
    def isEmpty = true
    def head = throw new NoSuchElementException("empty.head")
    def tail = throw new NoSuchElementException("empty.tail")
  }
}













