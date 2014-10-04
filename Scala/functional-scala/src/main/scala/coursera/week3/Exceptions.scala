package coursera.week3

/**
 * Created by christian.sisti on 04/10/2014.
 */
class Exceptions {

  object ThrowSomething {
    def crash: Nothing = throw Exc // the type of this expression is Nothing
  }
}
