package coursera.week1

import coursera.Utilities
import coursera.Utilities.time

/**
 * Created by christian.sisti on 07/12/2013.
 */
object NewtonSqrt {
  def main(args: Array[String]) {
    val x = 1e50
    time {println("Square root of : " + x + " = " + sqrt(x))}
  }

  /** Only sqrt is visible, this prevent also namespace pollution.
    * Also the parameter x is visible within the scope of all
    * the functions' definitions.
    */
  def sqrt(x: Double) : Double = {

    def guessSqrt(guess: Double) : Double = {
      val nextGuess = improve(guess)
      if (isBetterEnough(guess, nextGuess)) nextGuess
      else guessSqrt(nextGuess)
    }

    def isBetterEnough(guess: Double, nextGuess: Double) = {
      Math.abs(nextGuess - guess) < 0.1
    }

    def improve(guess: Double) = {
      (x / guess + guess) / 2
    }

    guessSqrt(1.0)
  }
}
