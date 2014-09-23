package coursera.week2

/**
 * Created by christian.sisti on 23/09/2014.
 */
object Currying {
  def main(args: Array[String]): Unit = {
    // Higher Order and Anonymous
    println("Anonymous.sumInts: " + Anonymous.sumInts(1, 2))
    println("Anonymous.sumCubes: " + Anonymous.sumCubes(1, 2))
    // Currying
    println("Currying.sum (Ints): " + Currying.sum(x => x)(1, 2))
    println("Currying.sum (Cubes) " + Currying.sum(x => x * x * x )(1, 2))
  }

  // From the previous lesson
  object Anonymous {
    def sum(f: Int => Int, a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sum(f, a + 1, b)
    }
    def sumInts(a: Int, b: Int) = sum(x => x, a, b)
    def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
  }

  // Currying - is the technique of translating the evaluation of a function that takes multiple
  // arguments (or a tuple of arguments) into evaluating a sequence of functions, each with a single argument
  // (partial application).
  object Currying {
    // With this syntax we define a function (sum) which takes a function as single, only parameter (f),
    // and then return a function which result can be applied to the parameters (a, b).
    //
    // f(n1)(n2)...(nn) = E  is equivalent to f = (n1 => (n2 => ... (nn => E)...))
    //
    // This style of definition and function application is called currying
    def sum(f: Int => Int)(a: Int, b: Int): Int = {
        if (a > b) 0
        else f(a) + sum(f)(a + 1, b)
    }

    // The benefit of this syntax is that we separate the function definition from the parameter it takes,
    // that can be passed from different contexts.
    sum(x => x)(1, 2)
    sum(x => x * x * x)(1, 2)
  }
}
