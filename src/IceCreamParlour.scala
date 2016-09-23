import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by amit on 8/24/2016.
  */
object IceCreamParlour {

  private class Trip(totalMoney: Int, flavorsCount: Int, flavorsLst: List[Int]) {
    def getTotalMoney: Int = totalMoney

    def getFlavorsCounnt: Int = flavorsCount

    def getFlavorList: List[Int] = flavorsLst
  }

  def main(args: Array[String]) {
    //    println("Enter number of trips")
    val totalTrpis = StdIn.readInt();
    var trips = ListBuffer[Trip]()
    for (x <- 1 to totalTrpis) {
      //      println("Enter total money: ")
      val totalMoney = StdIn.readInt()
      //      println("Enter total flavors: ")
      val flavorsCount = StdIn.readInt()
      //      println("enter price of all " + flavorsCount + " separated by spaces")
      val flavorsPriceStr = StdIn.readLine()
      if (flavorsPriceStr.isEmpty)
        throw new IllegalArgumentException("flavors list is empty")
      val flavorsLst = flavorsPriceStr.split(" ").toList.map(_.toString).map(_.toInt)
      val trip = new Trip(totalMoney, flavorsCount, flavorsLst)
      trips += trip
    }
    findMatches(trips.toList).foreach(println)

    def findMatches(trips: List[Trip]): List[String] = {
      var buffer = ListBuffer[String]()
      var counter=0
      for (trip <- trips;
           (item0,index) <- trip.getFlavorList.zipWithIndex;
           item1 <- trip.getFlavorList.drop((index + 1))) {
        if (item0 + item1 == trip.getTotalMoney) {
          buffer += (trip.getFlavorList.indexOf(item0) + 1).toString + " " + (trip.getFlavorList.lastIndexOf(item1) + 1).toString
        }
      }
      buffer.toList
    }
  }


}




