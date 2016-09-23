import scala.collection.mutable.ListBuffer

/**
  * Created by amit on 9/1/2016.
  */
object CavityMap {

  private class CavityMap(n: Int, N: Array[String]) {
    def findCavities(): List[String] = {
      var cavities = ListBuffer[String]()
      var map = N

      for ((row, index) <- map.zipWithIndex) {
        var str = ""
        var rowArr = row.toCharArray
        for ((l, lIndex) <- rowArr.zipWithIndex) {
          if (lIndex == 0 || lIndex == (n - 1) || index == 0 || index == (n - 1))
            str += l
          else {
            val prevRowArr = map(index - 1).toCharArray
            val nextRowArr = map(index + 1).toCharArray
            if (l.toInt > rowArr(lIndex - 1).toInt
              && l.toInt > rowArr(lIndex + 1).toInt
              && l.toInt > prevRowArr(lIndex).toInt
              && l.toInt > nextRowArr(lIndex).toInt)
              str += "X"
            else str += l
          }
        }
        cavities += str
      }
      cavities.toList
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var grid = new Array[String](n);
    for (grid_i <- 0 to n - 1) {
      grid(grid_i) = sc.next();
    }
    val map = new CavityMap(n, grid)
    map.findCavities().foreach(println)
  }

}
