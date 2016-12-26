package puzzle

/**
  * Puzzle1.
  * - mapと関数リテラルについて
  *
  */
object Puzzle1 {
  def main(args: Array[String]): Unit = {
    /**
      * args => expr という関数リテラルとして認識されるため
      * 繰り返すたびにprintlnが呼ばれる
      */
    val list1 = List(1, 2).map {i =>
      println("Hi")
      i + 1
    }
    println(list1)
    println()
    /**
      * println("Hi")と"_ + 1"の二つの式と認識されるため
      * 最後の式である"_ + 1"が渡される
      * printlnは関数の一部ではなく、mapに渡される際に１度実行される
      */
    val list2 = List(1, 2).map {
      println("Hi")
      _ + 1
    }
    println(list2)
    println()
    val printAndReturnAFunction = {
      println("Hi")
      (_: Int) + 1
    }
    val list3 = List(1, 2).map(printAndReturnAFunction)
    println(list3)
    println()
    val printAndReturnAFunction2 = (i: Int) => {
      println("Hi")
      i + 1
    }
    val list4 = List(1, 2).map(printAndReturnAFunction2)
    println(list4)
    println()
  }
}
