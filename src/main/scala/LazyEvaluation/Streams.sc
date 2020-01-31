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




















