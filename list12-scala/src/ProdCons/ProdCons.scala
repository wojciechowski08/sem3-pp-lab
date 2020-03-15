class Buffer {
  private var msg: String = _
  private var empty = true

  def put(msg: String) = this.synchronized {
    while (!empty) wait()
    println(s"${Thread.currentThread().getName} puts $msg")
    this.msg = msg
    empty = false
    notifyAll
  }

  def take: String = this.synchronized {
    while (empty) wait()
    empty = true
    notifyAll
    println(s"${Thread.currentThread().getName} takes $msg")
    msg
  }
}

class BoundedBuffer(N: Int) {
  private var in, out, n: Int = 0
  private val elems = new Array[Int](N)

  def put(x: Int) = this.synchronized {
    while (n >= N) {println(s"${Thread.currentThread.getName} waiting"); wait}
      elems(in) = x ; in = (in + 1) % N ; n += 1; println(s”${Thread.currentThread.getName} putting $x”)
      elems.foreach(e => print(s”$e ")); println
      if (n == 1) notifyAll
  }
  def take: Int = this.synchronized {
    while (n == 0) {println(s"${Thread.currentThread.getName} waiting"); wait}
      val x = elems(out) ; elems(out) = 0 ; out = (out + 1) % N ; n -= 1
      elems.foreach(e => print(s”$e ")); println
      if (n == N-1) notifyAll
      x
  }


}

class Producer(name: String, buf: Buffer) extends Thread(name) {
  override def run: Unit = {
    for (i <- 1 to 10) buf.put(s"m$i")
    buf.put("Done")
  }
}

class Consumer(name:String, buf: Buffer) extends Thread(name) {
  override def run: Unit = {
    var msg = ""
    do {
      msg = buf.take
    } while (msg != "Done")
  }
}

object ProdCons {
  def main(args: Array[String]): Unit = {
    val buf = new Buffer
//    val buf: BoundedBuffer = new BoundedBuffer(5)
    new Producer("Pro", buf).start
    new Consumer("Con", buf).start
  }
}