package chapter3.list

object Tester {
  def main(args: Array[String]): Unit = {
//    println(List.sum2(List(1, 2, 4, 6, 7)))
//    println(List.sum3(List(1, 2, 4, 6, 9)))
//    println(List.product3(List(1, 2, 3, 4, 5)))
//    println(List.reverse(List(1, 2, 3, 4, 5)))
    println(List.append(List(1, 2, 3, 4, 5), List(12, 34, 5)))
    println(List.concat(List(List(1, 2, 4, 5), List(6, 7, 8), List(9, 10, 11))))
    println(List.map(List(1, 2, 3, 4, 5))(_ * 2))
    println(List.filter(List(1,2,3,4,5,6,7,8))(_ % 2 == 0))
  }
}