package puzzle

/**
  * Puzzle2.
  * - 大文字と小文字の挙動の違いについて
  *
  */
object Puzzle2 {

  def main(args: Array[String]): Unit = {
    val MONTH = 12
    val DAY = 20
    val HOUR = 10
    val MINUTE = 10
    val SECOND = 10

    /**
      * - パターンマッチに基づいているため、大文字で始まる変数名は安定識別子という特別な意味を持つ
      * - 安定識別子は定数のマッチさせたい場合に使用するため事前に初期化する必要ある
      */
    try {
      val (HOUR, MINUTE, SECOND) = (13, 10, 10) // 異なった値にするとMatchError
      println(s"""$MONTH/$DAY $HOUR:$MINUTE:$SECOND""")
    } catch {
      case e: MatchError => println("Match Error")
    }
    // 小文字の場合は変数代入パターンになる
    val (hour, minute, second) = (13, 30, 20)
    println(s"""$MONTH/$DAY $hour:$minute:$second""")
  }
}
