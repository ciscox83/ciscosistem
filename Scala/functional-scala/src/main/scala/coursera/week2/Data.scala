package coursera.week2

/**
 * Created by christian.sisti on 24/09/2014.
 */
object Data {
  def main(args: Array[String]): Unit = {
    println("Sequence1.sumInts: " + sumInts(1, 2))
    println("Sequence2.sumInts: " + new Sequence2(1, 2).sumInts())
    println("Sequence3.sumInts: " + new Sequence2(1, 2).sumInts())
    println("Sequence3.sumInts negatives: " + new Sequence3(-1, -2).sumInts())
  }

  // Sequence is a new type and a constructor which takes two params
  class Sequence1(a: Int, b: Int) {
    def start = a
    def end = b
  }

  // So now we can write the function sum again, but passing an object of type Sequence as param
  def sum(f: Int => Int, s: Sequence1): Int = {
    if (s.start > s.end) 0
    else f(s.start) + sum(f, new Sequence1(s.start + 1, s.end))
  }
  def sumInts(a: Int, b: Int) = sum(x => x, new Sequence1(a, b))

  // Sequence is a new type and a constructor which takes two params
  def sum2(f: Int => Int, s: Sequence2): Int = {
    if (s.start > s.end) 0
    else f(s.start) + sum2(f, new Sequence2(s.start + 1, s.end))
  }
  class Sequence2(a: Int, b: Int) {
    def start = a
    def end = b
    def sumInts() = sum2(x => x, this) // this represent the object on which the current method is executed
  }


  // asserts and preconditions
  // we can also impose preconditions
  class Sequence3(a: Int, b: Int) {
    // preconditions are used to enforce the caller to met the function requirements
    require(a >= 0 && b >=0, "Values must be positive") // throw IllegalExceptions
    // assert are used to check the code of the function
    assert(a >= 0 && b >=0, "Values must be positive") // generate java.lang.AssertionError
    def sum(f: Int => Int, s: Sequence3): Int = {
      if (s.start > s.end) 0
      else f(s.start) + sum(f, new Sequence3(s.start + 1, s.end))
    }
    def start = a
    def end = b
    def sumInts() = sum(x => x, this)
  }
}
