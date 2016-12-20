package exercise1

/**
  * FizzBuzz.
  * - なんか偉い人が考えた問題
  * - ルールは以下の通り
  *   - 1から順番に数を表示する
  *   - その数が3で割り切れるなら"Fizz"、5で割り切れるなら"Buzz"、両方で割り切れるなら"FizzBuzz"と表示する
  *   - 要するに"1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz ･･･"と出力される
  */
object FizzBuzz {

  def main(args: Array[String]): Unit = {
    val num = args.headOption.map(_.toInt).getOrElse(30)
    println(s"""number: $num""")
    (1 to num).foreach(n => println(s"""$n: ${fizzBuzz(n)}"""))
  }

  def fizzBuzz(number: Int) = {
    number match {
      case n if n % 3 == 0 && n % 5 == 0 => "FizzBuzz"
      case n if n % 3 == 0 => "Fizz"
      case n if n % 5 == 0 => "Buzz"
      case _ => number.toString
    }
  }
}
