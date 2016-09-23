import scala.util.control.Breaks._

/**
  * Created by amit on 9/1/2016.
  */
object Kangaroo {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var x1 = sc.nextInt();
    var v1 = sc.nextInt();
    var x2 = sc.nextInt();
    var v2 = sc.nextInt();
    val resp =
      if (v2 > v1 && x2 > x1) "NO"
      else if (v2 == v1 && x2 > x1) "NO"
      else if (v2 == v1 && x1 < x2) "NO"
      else if (v2 == v1 && x2 == x1) "YES"
      else {
        if ((x2 - x1) % (v2 - v1) == 0) "YES"
        else "NO"
      }
    println(resp)
  }

}
