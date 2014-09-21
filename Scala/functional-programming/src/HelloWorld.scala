/**
 * Created by christian.sisti on 07/12/2013.
 */
class HelloWorld {
  def main(args: Array[String]) {
    val x = "Hello"
    val y = "World!"

    print(x, y)
    args.foreach((y: String) => println(y))
  }

  def print(x: String, y: String) {
    println(x + " " + y)
  }
}