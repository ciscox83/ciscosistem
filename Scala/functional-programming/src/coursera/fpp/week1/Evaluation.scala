package coursera.fpp.week1

/**
 * Created by christian.sisti on 07/12/2013.
 */
object Evaluation {
  def main (args: Array[String]) {
    def name = loop
    print("By name: " + constOneByName(1 + 2, loop))   // print
    print("By name: " + constOneByName(loop, 1 + 2))   // loop
    print("By value: " + constOneByValue(1 + 2, loop)) // loop
    print("By value: " + constOneByValue(loop, 1 + 2)) // loop

  }

  // evaluate x,y by value
  def constOneByValue(x: Int, y: Int) = 1

  //evaluate x by value and y by name
  def constOneByName(x: Int, y: => Int) = 1

  def loop : Int = loop

  //////////////
  // EXAMPLES //
  //////////////
  def and(x: Boolean, y: => Boolean) = {
    if(x) y else false
  }

  def or(x: Boolean, y: => Boolean) = {
    if(x) true else y
  }
}
