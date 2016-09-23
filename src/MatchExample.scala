/**
  * Created by amit on 8/17/2016.
  */
object MatchExample extends App {

  var x = if (args.length > 0) args(0) else ""
  var add= (add:Int) => add+1
  println("add=" + add)
  var res = add(15)
  println(res)
  var y = x match {
    case "Amit" => "Karir"
    case "Zill" => "Rehman"
    case _ => "No One Here"
  }
  println(y)
  if (args.length == 2) {
    val lineNum: Int = Integer parseInt args(1)
    var y = 0
    val chartoPrint = "#"
    for (x <- 1 to lineNum) {
      for (y <- 6 to x) {
        print(chartoPrint)
      }
      println("\n")
    }


  }
}
