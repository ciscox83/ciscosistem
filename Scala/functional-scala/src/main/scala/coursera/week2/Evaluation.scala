package coursera.week2

/**
 * Created by christian.sisti on 25/09/2014.
 */
object Evaluation {
  def main(args: Array[String]): Unit = {
    val s = new Sequence(1, 2)
    println(s.getSame(2))
    println(s getSame 2)   // 1. any method which takes one single param can be written in an infix form
    val :-* = 2
    println (:-*) // 2. the identifiers are relaxed so that also operator can be used

    val | = new magic()
    val || = 2
    println (| + ||)
    println ("| + || = " + | + ||)
    println (|| * || + | * ||)
    println ("|| * || + | * || =" + || * || + | * ||)
    println (|| * || * ||)
    println ("|| * || * || =" + || * || * ||)
  }

  class magic() {
    def *(x: Int) = x * x
    def +(x: Int) = x + 1
  }

  class Sequence(a: Int, b: Int) {
    def sum(f: Int => Int, s: Sequence): Int = {
      if (s.start > s.end) 0
      else f(s.start) + sum(f, new Sequence(s.start + 1, s.end))
    }
    def start = a
    def end = b
    def sumInts() = sum(x => x, this)
    def getSame(a: Int) = a
  }


}
