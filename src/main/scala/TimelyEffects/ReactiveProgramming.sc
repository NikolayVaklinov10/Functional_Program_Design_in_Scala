// Example: Mouse Positions

// Event-based view:
// Whenever the mouse moves, an event

//MouseMoved(toPos: Position)
//// is fired.
//// FRP view:
//// A signal,

// Fundamental Signal Operations

// Define a signal in terms of other signals
def inReactangle(LL: Position, UR: Position): Signal[Boolean] =
  Signal{
    val pos = mousePosition()
    LL <= pos && pos <= UR
  }



















