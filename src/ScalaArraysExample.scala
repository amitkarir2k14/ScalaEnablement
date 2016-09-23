/**
  * Created by amit on 8/5/2016.
  */
object ScalaArraysExample extends App{

  var myArr = new Array[String](5)
  val initializedArr = Array("Apple", "Microsoft", "Google")
  initArray
  var concatenatedList = myArr.toList ::: initializedArr.toList
  val concatenatedArrayFromList = concatenatedList.toArray
  printArray
  println("concatenated array = " + concatenatedList)
  println("concatenated list from array = " + concatenatedArrayFromList)

  def printArray = {myArr.foreach(s => println(s))
  for(arr <- initializedArr) println(arr)
  }

  def initArray: Unit = {
    for (arr <- 0 to 4) {
      myArr(arr) = String.valueOf(arr)
    }
  }

}
