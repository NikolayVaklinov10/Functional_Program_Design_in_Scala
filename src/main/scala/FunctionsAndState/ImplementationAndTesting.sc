import akka.actor.FSM.Event

trait Simulation{
  type Action = () => Unit
  case class Event(time: Int, action: Action)
  private type Agenda = List[Event]
  private var agenda: Agenda = List()
}

// Implementation of AfterDelay
def afterDelay(delay: Int)(block: => Unit): Unit = {
  val item = Event(currentTime + delay, () => block)
  agenda = insert(agenda, item)
}

// The Insert function implementation
private def insert(ag: List[Event], item: Event): List[Event] = ag match {
  case first :: rest if first.time <= item.time =>
    first :: insert(rest, item)
  case _ =>
    item :: ag
}

// The Event Handling Loop
private def loop(): Unit = agenda match {
  case first :: rest =>
    agenda = rest
    curtime = first.time
    first.action()
    loop()
  case Nil =>
}


// The Run Method
def run(): Unit = {
  afterDelay(0){
    println("*** simulation started, time = "+currentTime+" ***")
  }
  loop()
}

// Probes
// Before launching the simulation, a way to examine the changes of the signals
// on the wires is needed
def probe(name: String, wire: Wire): Unit = {
  def probeAction(): Unit = {
    println(s"$name $currentTime value = ${wire.getSignal}")
  }
  wire addAction probeAction
}
















