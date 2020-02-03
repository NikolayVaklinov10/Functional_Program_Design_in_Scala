import akka.io.Dns.Command
// Loops

// Proposition: Variables are enough to model all
// imperative programs.

// Scala loop example
def power(x: Double, exp: Int): Double = {
  var r = 1.0
  var i = exp
  while (i > 0){ r = r * x; i = i - 1 }
  r
}

// Definition of while
// The function WHILE can be defined as follows:
def WHILE(condition: => Boolean)(command: => Unit): Unit =
  if (condition){
    command
    WHILE(condition)(command)
  }
else()

// Exercise
// Write a function implementing a repeat loop that is
// used as follows:

def REPEAT(command: => Unit)(condition: => Boolean):Unit = {
  command
  if (condition)()
  else REPEAT(command)(condition)
}









