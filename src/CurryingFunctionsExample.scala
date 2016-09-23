

/**
  * Created by amit on 8/23/2016.
  */
object CurryingFunctionsExample extends App{

  def add(x:Int)(y:Int)= x+y
  println(add(2)(3))
  val threePlus = add(3)_
  println(threePlus(2))
  def add2(x:Int)=(y:Int) => x+ y
  var x= add2(3)
  println(x(2))




}
