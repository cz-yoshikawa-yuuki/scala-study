package exercise

/**
  * PrimeNumber.
  *
  * - 素数判定
  * - 素数とは、自明な正の約数（1 と自分自身）以外に約数を持たない自然数であり、1 でない数のことである。
  */
object PrimeNumber {

  def main(args: Array[String]): Unit = {
    val num = args.headOption.map(_.toInt).getOrElse(30)
    println(s"""number: $num""")
    println("===== isPrimeNumber =====")
    (1 to num).foreach(n => println(s"""$n: ${isPrimeNumber1(n)}"""))
  }

  def isPrimeNumber1(n: Int): Boolean =
    2 <= n && !(2 until (math.sqrt(n) + 1.0).toInt).exists(n % _ == 0)
}
