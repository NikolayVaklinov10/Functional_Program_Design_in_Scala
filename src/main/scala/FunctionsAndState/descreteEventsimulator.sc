// A discrete event simulator performs actions, specified by the user at a given moment

// An action is a function that doesn't take any parameters and which returns Unit:

type Action = () => Unit

// the time is simulated; it has nothing to with the actual time.

type Action = () => Unit

// The time is simulated; it has nothing to with the actual time.

// Simulation Trait

// A concrete simulation happens inside an object that inherits
// from the Trait simulation, which has the following signature:

trait Simulation{
  def currentTime: Int = ???
  def afterDelay(delay: Int)(block: => Unit): Unit = ???
  def run(): Unit = ???
}


// Here, currentTime returns the current simulated time in the form of an integer.
// afterDelay registers an action to perform after a certain delay (relative to the current time currentTime)

// Implementation of Wires

class Wire{
  private var sigVal = false
  private var actions: List[Action] = List()
  def getSignal: Boolean = sigVal
  def setSignal(s: Boolean): Unit =
    if (s!= sigVal){
      sigVal = s
      actions foreach(_())
    }
  def addAction(a: Action): Unit = {
    actions = a :: actions
    a()
  }
}


// The Inverter
def inverter(input: Wire, output: Wire): Unit = {
  def invertAction(): Unit = {
    val inputSig = input.getSignal
    afterDelay(InverterDelay){ output setSignal !inputSig }
  }
  input addAction invertAction
}

// The AND Gate

def andGate(in1: Wire, in2: Wire, output: Wire): Unit ={
  def andAction(): Unit = {
    val in1Sig = in1.getSignal
    val in2Sig = in2.getSignal
    afterDelay(AndGateDelay) { output setSignal (in1Sig & in2Sig) }
  }
  in1 addAction andAction
  in2 addAction andAction
}

// The OR Gate
def orGate(in1: Wire, in2: Wire, output: Wire): Unit ={
  def orAction(): Unit = {
    val in1Sig = in1.getSignal
    val in2Sig = in2.getSignal
    afterDelay(orGateDelay) { output setSignal (in1Sig | in2Sig) }
  }
  in1 addAction orAction
  in2 addAction orAction
}












