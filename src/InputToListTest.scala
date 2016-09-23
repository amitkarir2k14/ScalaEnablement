import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by amit on 8/29/2016.
  */
object InputToListTest extends App {
  var inputList = ListBuffer[Int]()
  val N = StdIn.readInt()
  for (x <- 1 to N) {
  inputList += StdIn.readInt()
}
  inputList.foreach(println)
}
