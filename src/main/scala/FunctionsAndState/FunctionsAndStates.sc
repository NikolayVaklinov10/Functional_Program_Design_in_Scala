// Rewriting Example:
// Say you have the following functions iterate and square:

def iterate(n: Int, f: Int => Int, x: Int) =
  if(n == 0) x else iterate(n-1, f, f(x))
def square(x: Int) = x * x
// Then the call iterate(1, square, 3) gets rewritten as follows:

// Rewriting can be done anywhere in the term, and all rewritings
// which terminate lead to the same solution.

// This is an important result of the lambda-calculus, the theory
// behind functional programming.
// Example:
if(1 == 0) 3 else iterate(1 - 1, square, square(3))

// Stateful Objects
// One normally describes the world as a set of objects, some of
// which have state that changes over the course of time.

// An object has a state if its behaviour is influenced by its history.

// Example: a bank account has a state, because the answer to the question

// "can I withdraw 100 CHF ?"

// may vary over the course of the lifetime of the account.


















