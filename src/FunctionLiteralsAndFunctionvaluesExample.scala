/**
  * Created by amit on 8/23/2016.
  */
object FunctionLiteralsAndFunctionvaluesExample extends App {

  def sum(x: Int, y: Int, z: Int): Int = x + y + z


  val increase = (x: Int) => x + 1
  val sumVal = sum _
  val onlyoneMissingparam=sum(_:Int,12,13)

  val b = sumVal(10, 20, 30)
  val c = onlyoneMissingparam(12)
  println(b)
  println(c)
  //closure

  var test=11
  val testClosureFunc=(x:Int) => x+test

  println(testClosureFunc(10))

  test=12

  println(testClosureFunc(10))



}
