package puzzle

import collection.mutable.Buffer

/**
  * Puzzle7.
  * - 遅延アクセサ（varやmutableなobjectを自由変数として扱わない（キャプチャしない））
  */
object Puzzle7 {

  def main(args: Array[String]): Unit = {
    val accessor1 = Buffer.empty[() => Int]
    val accessor2 = Buffer.empty[() => Int]
    val accessor3 = Buffer.empty[() => Int]

    val data = Seq(100, 110, 200)
    var j = 0 // varにした場合はcompileする際にscala.runtime.IntRefとして扱われる。
    for (i <- data.indices) {
      accessor1 += (() => data(i))
      accessor2 += (() => data(j))
      // varの場合は一旦val変数に格納すれば、エラーが発生しない
      val currentJ = j
      accessor3 += (() => data(currentJ))
      j += 1
    }
    println("accessor1")
    accessor1.foreach(a1 => println(a1()))
    // 呼び出されたタイミングで変数jを参照する為、このタイミングでは"j = 3"であり、IndexOutOfBoundExceptionが発生する
    println("accessor2")
    try {
      accessor2.foreach(a2 => println(a2()))
    } catch {
      case e: IndexOutOfBoundsException => println(e.toString)
    }
    println("accessor3")
    accessor3.foreach(a3 => println(a3()))

  }
}
