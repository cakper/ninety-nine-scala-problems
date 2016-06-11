import scala.annotation.tailrec

/**
  * Exercises: http://aperiodic.net/phil/scala/s-99/#lists
  *
  * For the list exercises, avoid using builtin functions such as length, slice, ...
  */
object S99List {
  // P01
  @tailrec
  def last[T](l: List[T]): T = l match {
    case x :: Nil => x
    case x :: xs => last(xs)
    case Nil => throw new NoSuchElementException
  }

  // P02
  @tailrec
  def penultimate[T](l: List[T]): T = l match {
    case Nil | List(_) => throw new NoSuchElementException
    case List(x, _) => x
    case _ => penultimate(l.tail)
  }

  // P03
  @tailrec
  def nth[T](pos: Int, l: List[T]): T = {
    require(pos >= 0)
    if (l.isEmpty) throw new NoSuchElementException
    pos match {
      case 0 => l.head
      case _ => nth(pos - 1, l.tail)
    }
  }

  // P04
  def length[T](l: List[T]): Int = l.foldLeft(0)((c: Int, _) => c + 1)

  //l.length

  // P05
  def reverse[T](l: List[T]): List[T] = {

    @tailrec
    def reverseR(acc: List[T], l: List[T]): List[T] = l match {
      case Nil => acc
      case x :: xs => reverseR(x :: acc, xs)
    }

    reverseR(Nil, l)
  }

  // P06
  def isPalindrome[T](l: List[T]): Boolean = l == reverse(l)

  // P07
  def flatten(l: List[Any]): List[Any] = l match {
    case Nil => Nil
    case (x: List[Any]) :: xs => flatten(x) ::: flatten(xs)
    case (x: Any) :: xs => x :: flatten(xs)
    case x: Any => List(x)
  }

  // P08
  def compress[T](l: List[T]): List[T] = ???

  // P09
  def pack[T](l: List[T]): List[List[T]] = ???

  // P10
  def encode[T](l: List[T]): List[(Int, T)] = ???

  // P11
  def encodeModified[T](l: List[T]): List[Any] = ???

  // P12
  def decode[T](l: List[(Int, T)]): List[T] = ???

  // P13
  def encodeDirect[T](l: List[T]): List[(Int, T)] = ???

  // P14
  def duplicate[T](l: List[T]): List[T] = ???

  // P15
  def duplicateN[T](n: Int, l: List[T]): List[T] = ???

  // P16
  def drop[T](n: Int, l: List[T]): List[T] = ???

  // P17
  def split[T](n: Int, l: List[T]): (List[T], List[T]) = ???

  // P18
  def slice[T](from: Int, to: Int, l: List[T]): List[T] = ???

  // P19
  def rotate[T](n: Int, l: List[T]): List[T] = ???

  // P20
  def removeAt[T](n: Int, l: List[T]): (List[T], T) = ???

  // P21
  def insertAt[T](elem: T, n: Int, l: List[T]): List[T] = ???

  // P22
  def range(from: Int, to: Int): List[Int] = ???

  // P23
  def randomSelect[T](n: Int, l: List[T]): List[T] = ???

  // P24
  def lotto(howMany: Int, outOf: Int): List[Int] = ???

  // P25
  def randomPermute[T](l: List[T]): List[T] = ???

  // P26
  def combinations[T](n: Int, l: List[T]): List[List[T]] = ???

  // P27
  def group3[T](l: List[T]): List[List[List[T]]] = ???

  def group[T](groupSizes: List[Int], l: List[T]): List[List[List[T]]] = ???

  // P28
  def lsort[T](l: List[List[T]]): List[List[T]] = ???

  def lsortFreq[T](l: List[List[T]]): List[List[T]] = ???
}
