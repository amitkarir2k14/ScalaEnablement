import com.sun.javafx.scene.layout.region.Margins.Converter

import scala.collection.mutable

/**
  * Created by amit on 8/10/2016.
  */
class Converter {

  private var sum: Int = 0

  private def add(b: Byte): Unit = sum += b

  private def checkASum(): Int = (sum & 0xFF) + 1


}

object Converter {
  private val cache = mutable.Map.empty[String, Int]
//  calculate("This is a singleton text")
  println("cache"  + cache)

  def calculate(s: String): Int = {
    if (cache.contains(s))
      cache(s)
    else {
      val converter = new Converter
      for (c <- s)
        converter.add(c.toByte)
      val cs = converter.checkASum()
      cache += (s -> cs)
      cs
    }
  }
}
