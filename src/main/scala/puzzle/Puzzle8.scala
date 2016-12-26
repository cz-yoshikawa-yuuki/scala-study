package puzzle

/**
  * Puzzle8.
  *
  * - for, Mapの内包表記
  */
object Puzzle8 extends App {
  val xs = Seq(Seq("a", "b", "c"), Seq("d", "e", "f"), Seq("g", "h"), Seq("i", "j", "k"))
  val forResult = for(Seq(x, y, z) <- xs) yield x + y + z
  println(s"""forResult: $forResult""")
  // 上記のforは以下のように書き換えられるためMatchErrorは怒らず、マッチするもののみを抽出する
  val forResultEqualDefinition = xs.withFilter{
    case Seq(x, y, z) => true
    case _ => false
  }.map { case Seq(x, y, z) => x + y + z}
  println(s"""forResult: $forResultEqualDefinition""")
  try {
    val mapResult = xs.map {case Seq(x, y, z) => x + y + z}
    println(s"""mapResult: $mapResult""")
  } catch {
    case e:MatchError => println(s"""forResult: ${e.toString}""")
  }
}
