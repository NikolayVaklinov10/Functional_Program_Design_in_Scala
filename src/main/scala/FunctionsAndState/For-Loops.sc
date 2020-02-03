// Translation of For-Loops
// For-loops translate similarly to for-expressions, but
// using the foreach combinator instead of map and flatMap.

// foreach is defined on collections with elements of type T
// as follows:
def foreach(f: T => Unit): Unit =
  // apply 'f' to each element of the collection

// Example

for (i <- 1 until 3; j <- "abc") println(i + " " + j)

// translates to:
(1 until 3) foreach(i => "abc" foreach(j => println(i + " " + j)))





















