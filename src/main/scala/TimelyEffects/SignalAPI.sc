// The Signal API
class Signal[T](expr: => T){
  def apply(): T = ???
}

object Signal{
  def apply[T](expr: => T) = new Signal(expr)
}

// The Var API
class Var(expr: => T) extends Signal[T](expr){
  def update(expr: => T): Unit = ???
}

object Var{
  def apply[T](expr: => T) = new Var(expr)
}
















