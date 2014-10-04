package coursera.week3

/**
 * Created by christian.sisti on 04/10/2014.
 */
class Traits {

  trait Planar {
    def height: Int
    def width: Int
    def surface: Int = height * width
  }
}
