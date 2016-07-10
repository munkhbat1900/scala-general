package problems99

object Tester {
  def main(args: Array[String]): Unit = {
    println(Problems.last(List(1, 2, 4, 5)))
    println(Problems.lastButOne(List(1, 2, 3, 4, 5, 6, 7)))
    println(Problems.kth(List(1, 2, 3, 4, 5, 6, 7), 10))
    println(Problems.numOfElems(List()))
    println(Problems.numOfElems(List(1, 2, 3, 4, 5, 6, 7, 8)))
    println(Problems.reverseViaFoldLeft(List(1, 2, 3, 4, 5, 6, 7, 8)))
    println(Problems.reverseTail(List(1, 2, 3, 4, 5, 6, 7, 8)))
    println(Problems.isPalindrome(List(1, 2, 3, 4, 5, 4, 3, 2, 1)))
  }
}