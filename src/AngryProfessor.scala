import scala.collection.mutable.ListBuffer

object AngryProfessor {
  private class Class(n: Int, k: Int, a: Array[Int]) {
    def isCancelled(): Boolean = {
      val joinedOnTimeArr = a.filter(_ <= 0)
      if (joinedOnTimeArr.length >= k) false else true
    }
  }
  def main(args: Array[String]) {
    var classList = ListBuffer[Class]()
    val sc = new java.util.Scanner(System.in);
    var t = sc.nextInt();
    var a0 = 0;
    while (a0 < t) {
      var n = sc.nextInt();
      var k = sc.nextInt();
      var a = new Array[Int](n);
      for (a_i <- 0 to n - 1) {
        a(a_i) = sc.nextInt();
      }
      classList += new Class(n, k, a)
      a0 += 1;
    }
    for(x:Class <- classList)
      println(if (x.isCancelled()) "YES" else "NO")
  }

}
