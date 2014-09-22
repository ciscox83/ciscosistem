package coursera

/**
 * Created by christian.sisti on 07/12/2013.
 */
object Utilities {
  /** Usage: time { anyFunction } **/
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }
}
