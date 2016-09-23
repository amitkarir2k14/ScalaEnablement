/**
  * Created by amit on 8/10/2016.
  */
object ConverterSingletonCallerExample extends App{
  for(s <- args)
  println(s + Converter.calculate(s))



}
