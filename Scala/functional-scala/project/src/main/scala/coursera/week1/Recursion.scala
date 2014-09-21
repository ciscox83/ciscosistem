package coursera.week1

import scala.annotation.tailrec

/**
 * Created by christian.sisti on 07/12/2013.
 */
object Recursion {
  def tailRecursionCool(i: Int, n: Int, f: (Int) => Any): Any = {
    if(i < n) {
      f(i)
      tailRecursionCool(i + 1, n, f)
    }
  }

  @tailrec
  def tailRecursion(i: Int, n: Int): Any = {
    if(i < n) {
      print(i + " ")
      tailRecursion(i + 1, n)
    }
  }

  def recursion(i: Int, n: Int): Any = {
    if(i < n) {
      recursion(i + 1, n)
      print(i + " ")
    }
  }

  def factorial(n: Int): Int = {
    if (n == 0) 1 else n * factorial(n - 1)
  }

  def factorialTail(n:Int): Int = {
    @tailrec
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc * n, n - 1  )
    }
    loop(1, n)
  }
}
