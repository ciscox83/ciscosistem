package coursera.week1

/**
 * Created by christian.sisti on 07/12/2013.
 */
object Definition {
  def main(args: Array[String]) {
    def byName = loop("byName ") //not evaluated
    val byValue = loop("byValue") //loop
  }

  def loop(x: String): Int = {
    println(x)
    loop(x)
  }
}
