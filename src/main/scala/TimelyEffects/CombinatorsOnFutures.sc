import scala.sys.process.processInternal.URL
import scala.util.{Failure, Success}
// Sending packets using futures

// The messy version of the code
val socket = Socket()
val packet: Future[Array[Byte]] =
  socket.readFromMemory()

packet onComplete {
  case Success(p) => {
    val confirmation: Future[Array[Byte]] =
      socket.sendToEurope(p)
  }
  case Failure(p) => ???
}

// The Functional Programming and More Elegant code
// with flatMap()

val socket = Socket()
val packet: Future[Array[Byte]] =
  socket.readFromMemory()

val confirmation: Future[Array[Byte]] =
  packet.flatMap(p => socket.sendToEurope(p))


// robustly
def sendTo(url: URL, packet: Array[Byte]): Future[Array[Byte]] =
Http(url, Request(packet))
  .filter(response => response.isOK)
  .map(response => response.toByteArray)

  def sendToAndBackup(packet: Array[Byte]):
  Future[(Array[Byte], Array[Byte])] = {

    val europeConfirm= sendTo(mailServer.europe, packet)
    val usaConfirm= sendTo(mailServer.usa, packet)
    europeConfirm.zip(usaConfirm)}
























