package problems99

import scala.collection.immutable.List

/**
 * @author Avirmed Munkhbat
 * solutions of some of 99 problems on scala.
 */
object Problems {
  def last[A](ls: List[A]): A =
    ls match{
    case x::Nil => x
    case _::xs => last(xs)
    case Nil => throw new IllegalArgumentException
  }
  
  @annotation.tailrec
  def lastButOne[A](ls: List[A]): A =
    ls match {
    case x::y::Nil => x
    case Nil | _::Nil => throw new IllegalArgumentException
    case x::xs => lastButOne(xs)
  }
  
  @annotation.tailrec
  def kth[A](ls: List[A], k: Int): Option[A] = {
    ls match {
      case Nil if k != 0 => None
      case x::xs if k == 0 => Some(x)
      case x::xs => kth(xs, k - 1)
    }
  }
  
  def numOfElems[A](ls: List[A]):Int = {
    @annotation.tailrec
    def count[A](ls: List[A], c: Int): Int = {
      ls match {
        case Nil => c
        case x::xs => count(xs, c + 1)
      }
    }
    count(ls, 0)
  }
  
//  @annotation.tailrec
//  def foldLeft[A, B](ls: List[A], z: B)(f:(B, A) => B): B = {
//    ls match {
//      case Nil => z
//      case x::xs => foldLeft(xs, f(z, x))(f)
//    }
//  }
  
  def reverseViaFoldLeft[A](ls: List[A]): List[A] = {
    ls.foldLeft(Nil:List[A])((ls1, v) => v::ls1)
  }
  
  
  /**
   * non tailrec
 * @param ls
 * @return
 */
  def reverse[A](ls: List[A]): List[A] = {
    ls match {
      case Nil => Nil
      case x::xs => reverse(xs):::List(x)
    }
  }
  
  def reverseTail[A](ls: List[A]): List[A] = {
    @annotation.tailrec
    def rec[A](l: List[A], res: List[A]): List[A] = {
      l match {
        case Nil => res
        case x::xs => rec(xs, x::res)
      }
    }
    rec(ls, Nil)
  }
  
  def isPalindrome[A](ls: List[A]): Boolean = {
    val ls1 = reverseTail(ls)
    @annotation.tailrec
    def rec[A](ls: List[A], ls1: List[A]): Boolean = {
      (ls, ls1) match{
        case (Nil, Nil) => true
        case (x::xs, y::ys) if x != y => false
        case (_::xs, _::ys) => rec(xs, ys)
      }
      
    }
    rec(ls, ls1)
  }
}