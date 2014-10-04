package coursera.week3

/**
 * Created by christian.sisti on 29/09/2014.
 */

/*
 * Class Hierarchy: more than one class cooperate to achieve a certain task
 */
object Hierarchy {
  def main(args: Array[String]): Unit = {
    val t1 = new BinaryTree(3, new LeafNode, new LeafNode)
    val t2 = t1 incl 4
    println(t1.toString)
    println(t2.toString)
  }
}

/*
 * As for Java, an abstract class can't be instantiated
 */
abstract class IntSet {

  // abstract class allow function definitions without implementation, like Java interfaces
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean = false
}

// Again, like Java interface we MUST implement the method when we 'extend' it
class LeafNode extends IntSet {
  // the override here is not required as the abstract class do not implement any method
  // but in the case that the IntSet would implement 'incl' we must use 'override'
  // in order to redefine the existing definition.
  def incl(x: Int): IntSet = new BinaryTree(x, new LeafNode, new LeafNode)

  // abstract class allow function definitions without implementation,
  override def contains(x: Int): Boolean = false

  override def toString = "."
}

/*
 * Impose the invariant that element on a left side are minor than any element on its right side (including the
 * parent node)
 *
 * This data structure is called "persistent" because even making changes to the data structure,
 * the previous version of the structure is maintained. In other words the data structure is immutable.
 * These kind of structures are a cornerstone of scaling functional programming.
 */
class BinaryTree(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  // abstract class allow function definitions without implementation, like Java interfaces
  def incl(x: Int): IntSet = {
    if (x < elem) new BinaryTree(elem, left.incl(x), right) // left inc x <=> left.incl(x)
    else if (x > elem) new BinaryTree(elem, left, right incl x)
    else this
  }

  override def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  override def toString = "{" + left + " " + elem + " " + right + "}"
}

/*
 * The fact that both BinaryTree and LeafNode (subclasses) 'extends' IntSet (superclass),
 * means that they are 'conform' to it.
 * In other word, we can use an instance of LeafNode or BinaryTree all the time that a type IntSet is required.
 */
// Creating a Singleton is as easy as making a class an object
object LeafNode extends IntSet {
  override def incl(x: Int): IntSet = new BinaryTree(x, new LeafNode, new LeafNode)
  override def contains(x: Int): Boolean = false
  override def toString = "."
}