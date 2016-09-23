import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by amit on 8/30/2016.
  */
object AngryChildren {


  def main(args: Array[String]) {
    val N = StdIn.readInt()
    val K = StdIn.readInt()
    var buffer = ListBuffer[Int]()
    for (n <- 1 to N)
      buffer += StdIn.readInt()
    var candiesList = buffer.distinct.sorted.toList.grouped(K).toList
    println(getMinimumUnfailness(candiesList.head))

    def getMinimumUnfailness(candiesList: List[Int]): Long = {
      var sum: Long = 0
      for ((x, xIndex) <- candiesList.zipWithIndex) {
        val sliced = candiesList.slice(xIndex + 1, candiesList.size)
        for ((y, yIndex) <- sliced.zipWithIndex) {
          sum += x - y
        }
      }
      sum abs
    }
  }
}
