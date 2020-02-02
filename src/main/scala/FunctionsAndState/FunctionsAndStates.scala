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


// In practice, objects with state are usually represented by
// objects that have some variable members.

// Example:Here is a class modeling a bank account.
class BankAccount{
  private var balance = 0
  def deposit(amount: Int): Unit = {
    if (amount > 0) balance = balance + amount
  }
  def withdraw(amount: Int): Int =
    if (0 < amount && amount <= balance) {
    balance = balance - amount
    balance
  }else throw new Error("insufficient funds")
}



















