import com.sun.corba.se.impl.ior.WireObjectKeyTemplate
// A Language for Digital Circuits

class Wire

// Class Wire models wires
val a = new Wire; val b = new Wire; val c = new Wire

// Gates
// Then there are following functions. Each has a side effect that creates a gate.

def inverter(input: Wire, output: Wire): Unit
def andGate(a1: Wire, a2: Wire, output: Wire): Unit
def orGate(o1: Wire, o2: Wire, output: Wire): Unit


// Constructing Components

// More complex components can be constructed from these.
// For example, a half-adder can be defined as follows:

def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire):Unit = {
  val d = new Wire
  val e = new Wire
  orGate(a, b, d)
  andGate(a, b, c)
  inverter(c, e)
  andGate(d, e, s)
}

// This half-adder can in turn be used to define a full adder:
def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, count: Wire): Unit = {
  val s = new Wire
  val c1 = new Wire
  val c2 = new Wire
  halfAdder(b, cin, s, c1)
  halfAdder(a, s, sum, c2)
  orGate(c1, c2, count)
}























