import scala.io.StdIn
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object GridSearch {

  var R, r, C, c = 0

  private class T(G: Array[String], P: Array[String]) {
    def getMainArray: Array[String] = G

    def getSubArray: Array[String] = P
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var t = sc.nextInt()
    var a0 = 0
    var buffer = ListBuffer[T]()
    while (a0 < t) {
      R = sc.nextInt();
      C = sc.nextInt();
      var G = new Array[String](R);
      for (G_i <- 0 to R - 1) {
        G(G_i) = sc.next();
      }
      r = sc.nextInt();
      c = sc.nextInt();
      var P = new Array[String](r);
      for (P_i <- 0 to r - 1) {
        P(P_i) = sc.next();
      }
      buffer += new T(G, P)
      a0 += 1;
    }
    for (t <- buffer.toList)
      println(if (IsSubMatrix(t.getMainArray, t.getSubArray)) "YES" else "NO")
  }

  def IsSubMatrix(array: Array[String], subArray: Array[String]): Boolean = {
    if (array.isEmpty || subArray.isEmpty) return false
    if (subArray.length > array.length || array.length < subArray.length) return false
    var firstMatchIndices, subRowStartIndices, subRowEndIndices = ListBuffer[Int]()
    //find row and and column indices  of the 1st row of sub matrix within big matrix
    for ((row, index) <- array.zipWithIndex) {
      if (row.contains(subArray(0))) {
        firstMatchIndices += index
        for ((string, strIndex) <- row.zipWithIndex) {
          val nextRowIndice = row.indexOf(subArray(0), strIndex)
          if (nextRowIndice >= 0 && !subRowStartIndices.contains(nextRowIndice)) {
            val str = row.substring(nextRowIndice, nextRowIndice + subArray(0).size)
            if (str.equals(subArray(0))) {
              subRowStartIndices += nextRowIndice
              subRowEndIndices += nextRowIndice + subArray(0).size
            }
          }
        }
      }
    }
    if (firstMatchIndices.isEmpty) return false
    var exists = false
    breakable {
      for (x <- 0 to firstMatchIndices.size - 1;
           y <- 0 to subRowStartIndices.size - 1) {
        val slicedBigMatrix: Array[String] = array.slice(firstMatchIndices(x), firstMatchIndices(x) + subArray.size).map(_.substring(subRowStartIndices(y), subRowEndIndices(y)))
        if (slicedBigMatrix.sameElements(subArray)) {
          exists = true
          break
        }
      }
    }
    if (!exists) return false
    return true
  }
}

