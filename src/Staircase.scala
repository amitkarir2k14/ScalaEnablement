import scala.io.StdIn

object StairCase {
  def main(args: Array[String]) {
    val hash = "#"
    val space = "\u0020"
    val height = StdIn.readInt()
    for (x <- 1 to height) {
      val numSpaces= height -x
      val numhashes = height - numSpaces
      for (y <- 0 to numSpaces)
        print(space)
      for(y<- 1 to numhashes)
        print(hash)
      println("")
    }
  }
}