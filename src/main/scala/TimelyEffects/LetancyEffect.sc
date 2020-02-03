// Simple Adventure Game
trait Adventure{
  def collectCoins(): List[Coin]
  def buyTreasure(coins: List[Coin]): Treasure
}

val adventure = Adventure()
val coins = adventure.collectCoins()
val treasure = adventure.buyTreasure(coins)

// Futures asynchronously notify consumers
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try

// this is a Monad
trait Future[T]{
  def onComplete(callback: Try[T] => Unit)
}

// ******** Callback needs to use pattern matching  **********

//ts match {
//  case Success(t) => onNext(t)
//  case Failure(e) => onError(e)
//}


trait Future[T]{
  def onComplete
    (success: T => Unit, failed: Throwable => Unit): Unit

  def onComplete(callback: Observer[T]): Unit
}

trait Observer[T]{
  def onNext(value: T): Unit
  def onError(error: Throwable): Unit
}

// Futures asynchronously notify consumers
trait Future[T]{
  def onComplete(callback: Try[T] => Unit)
}

trait Socket{
  def readFromMemory(): Future[Array[Byte]]
  def sendToEurope(packet: Array[Byte]): Future[Array[Byte]]
}





















