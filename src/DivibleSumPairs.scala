/**
  * Created by amit on 9/1/2016.
  */
object DivibleSumPairs {

  def findDivisiblePairs(k: Int, a: Array[Int]): Int = {
    var numMatchedPairs = 0
    for (x <- 0 to a.length - 1;
         y <- (x + 1) to a.length - 1) {
      if (((a(x) + a(y)) % k) == 0) numMatchedPairs += 1
    }
    numMatchedPairs
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var k = sc.nextInt();
    var a = new Array[Int](n);
    for (a_i <- 0 to n - 1) {
      a(a_i) = sc.nextInt();
    }
    println(findDivisiblePairs(k, a))
  }

}
