

// A language that grows on you
var capital = Map("US"-> "Washington", "France" -> "Paris")
capital += ("Japan"->"Tokyo")
println(capital("France"))

// Another example of Scala cool features
def factorial(x: BigInt): BigInt =
  if (x == 0) 1 else  x * factorial(x -1)

//The Java way
import java.math.BigInteger

import javafx.scene.chart.PieChart.Data

def factorial(x:BigInteger):BigInteger =
  if(x == BigInteger.ZERO)
    BigInteger.ONE
  else
    x.multiply(factorial(x.subtract(BigInteger.ONE)))

//Actor example in Scala
import akka.actor.Actor

actor{
  var sum = 0
  loop{
    case Data(bytes) => sum += hash(bytes)
    case GetSum(requester) => requester ! sum
  }
}





















