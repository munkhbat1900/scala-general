package chapter3.list

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = 
    as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }
  
  def sum2(ns: List[Int]) = 
    foldRight(ns, 0)(_ + _)
  
  @annotation.tailrec
  def foldLeft[A, B](as: List[A], z: B)(f:(B, A) => B): B =
    as match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  }
  
  def sum3(ns: List[Int]) = 
    foldLeft(ns, 0)(_ + _)
    
  def product3(ns: List[Int]) = 
    foldLeft(ns, 1)(_ * _)
  
  def reverse[A](ns: List[A]) = 
    foldLeft(ns, Nil: List[A])((x, y) => Cons(y, x))
    
  def foldRightViaFoldLeft[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    foldLeft(reverse(as), z)((a, b) => f(b, a))
  
  def append[A](l1: List[A], l2: List[A]): List[A] = 
    foldRightViaFoldLeft(l1, l2)((a, b) => Cons(a, b))
    
  def concat[A](l1: List[List[A]]): List[A] =
    foldRightViaFoldLeft(l1, Nil: List[A])(append)
    
  def add1(as: List[Int]): List[Int] =
    foldRightViaFoldLeft(as, Nil: List[Int])((x, y) => Cons(x + 1, y))
    
  def map[A, B](as : List[A])(f: A => B): List[B] =
    foldRightViaFoldLeft(as, Nil: List[B])((a, b) => Cons(f(a), b))
    
  def filter[A](as: List[A])(f : A => Boolean): List[A] = 
    foldRightViaFoldLeft(as, Nil: List[A])((a, b) => if (f(a)) Cons(a, b) else b)
  
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
    concat(map(as)(f))
}