import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Solution {
  def main(args: Array[String]) {
    val N = StdIn.readInt()
    val K = StdIn.readInt()
    var n = ListBuffer[Long]()
    for (x <- 1 to N) {
      n += StdIn.readInt()
    }
    val candies = n.toArray.sorted
    var array = new Array[Long](N)
    array(0) = candies(0)
    for (i <- 1 to candies.length - 1)
      array(i) = array(i - 1) + candies(i)
    var min: Long = 1000000000000000000L
    var res: Long = 0L
    var i = 0
    for (t <- i + K - 1 to (candies.length - 1)) {
      if (i > 0) {
        res += (K - 1) * candies(i - 1) + (K - 1) * candies(t)
        res -= 2 * (array(t - 1) - array(i - 1))
        min = minimum(min, res)
      }
      else {
        var m = (-1) * K + 1
        for (j <- i to t) {
          res += m * candies(j)
          m += 2
        }
        min = res
      }
      i += 1
    }
    println(min)
    def minimum(a: Long, b: Long): Long = {
      val i = if (b < a) b else a;

      i
    }
  }


}
 