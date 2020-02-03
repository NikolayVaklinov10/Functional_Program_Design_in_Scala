// A Publisher Trait
trait Publisher{
  private var subscribers: Set[Subscriber] = Set()
  def currentBalance = balance

  def subscribe(subscriber: Subscriber): Unit =
    subscribers += subscriber

  def unsubscribe(subscriber: Subscriber): Unit =
    subscribers -= subscriber

  def publish(): Unit =
    subscribers.foreach(_.handler(this))
}

class BankAccount extends Publisher{
  private var balance = 0

  def deposit(amount: Int): Unit =
    if(amount > 0) {
      balance = balance + amount
      // Invoke publish() every time when you change the state of the class
      publish()
    }
  def withdraw(amount: Int): Unit =
    if(0 < amount && amount <= balance){
      balance = balance -amount
      publish()
    }else throw new Error("Insufficient funds")
}

// An Observer
// A Subscriber to maintain the total balance of a list of accounts:
class Consolidator(observed: List[BankAccount]) extends Subscriber{
  observed.foreach(_.subscribe(this))

  private var total: Int = _
  compute()

  private def compute() =
    total = observed.map(_.currentBalance).sum
  def handler(pub: Publisher) = compute()

  def totalBalance = total
}




















