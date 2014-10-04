package coursera.week3

/**
 * Created by christian.sisti on 04/10/2014.
 */
class Polymorphism {

  // Polymorphism:  applied to functions means that a function type comes in "many forms". In other words, the function
  // can be applied  to arguments of many types OR the type can have instances of many types.
  //
  // Form of polymorphism are:
  // - subtyping: instances of a subclass can be passed to a base class
  // - generics: instances of a functions (or class) are created by type parametrisation
  //Type parametrisation: class as well as methods can have types as parameters


  // We define a trait using generic to consider all the possible type for a list
  trait List[T] {
    def isEmpty: Boolean

    def head: T

    def tail: List[T]
  }

  // val: evaluated when the object is first initialised
  // dev: evaluated each time the object is referenced
  //
  // Here is an example of usage of type parameters. They do not affect the evaluation in Scala
  // It is legal to assume that type parameters and type arguments are removed before evaluation, this is called
  // "type erasure". Also Java use type erasure, types are removed at compile time from the bytecode.
  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false;
  }

  // the Cons class define at the same time a parameter of the class and a field value definition
  // that is equivalent to:
  class Cons2[T](_head: T, _tail: List[T]) extends List[T]{
    val isEmpty = false
    val head = _head
    val tail = _tail
  }

  // empty list
  class Nil[T] extends List[T] {
    def isEmpty = true // The compiler can infer the type parameter (Boolean)
    def head = throw new NoSuchElementException("Nil.head") // Note the use of type Nothing for exceptions
    def tail = throw new NoSuchElementException("Nil.tail")
  }


}
