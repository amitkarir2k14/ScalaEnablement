import scala.collection.mutable.ListBuffer

/**
  * Created by amit on 9/1/2016.
  */
object CutTheSticks {

  def calcSticksCut(n: Int, arr: Array[Int]): ListBuffer[Int] = {
    var array = arr
    var buffer = ListBuffer[Int]()
    while (array.length != 0) {
      val filteredArr = array.map(_ - array.min).filter(_ > 0)
      buffer += array.length
      array = filteredArr
    }
    buffer
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for (arr_i <- 0 to n - 1) {
      arr(arr_i) = sc.nextInt();
    }
    calcSticksCut(n, arr).foreach(println)
  }
}
