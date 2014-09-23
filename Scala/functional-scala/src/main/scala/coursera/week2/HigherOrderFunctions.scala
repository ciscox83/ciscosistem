package coursera.week2

/**
 * Created by christian.sisti on 22/09/2014.
 */
object HigherOrderFunctions {
  def main(args: Array[String]): Unit = {
    // Classic
    println(Classic.sumInts(1, 2))
    println(Classic.sumCubes(1, 2))
    // Higher Order
    println(HigherOrder.sumInts(1, 2))
    println(HigherOrder.sumCubes(1, 2))
    // Higher Order and Anonymous
    println(Anonymous.sumInts(1, 2))
    println(Anonymous.sumCubes(1, 2))
  }

  // Classic approach
  object Classic {
    def sumInts(a: Int, b: Int): Int = {
      if (a > b) 0
      else a + sumInts(a + 1, b)
    }

    def sumCubes(a: Int, b: Int): Int = {
      def cube(x: Int) = x * x * x // First Order Function
      if (a > b) 0
      else cube(a) + sumCubes(a + 1, b)
    }
  }

  // Generalise using Higher Order Functions
  object HigherOrder {
    def sum(f: Int => Int, a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sum(f, a + 1, b)
    }

    def id(x: Int) = x

    def cube(x: Int) = x * x * x

    def sumInts(a: Int, b: Int) = sum(id, a, b)

    def sumCubes(a: Int, b: Int) = sum(cube, a, b)
  }

  // Generalise using Anonymous Functions
  object Anonymous {
    def sum(f: Int => Int, a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sum(f, a + 1, b)
    }

    def sumInts(a: Int, b: Int) = sum(x => x, a, b)

    def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
  }
}
