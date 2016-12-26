package puzzle

/**
  * Exercise6.
  */
object Exercise6 {

  def applyNMulti[T](n: Int)(arg: T, f: T => T) =
    (1 to n).foldLeft(arg) { (acc, _) =>
      f(acc)
    }

  def applyNCurried[T](n: Int)(arg: T)(f: T => T) =
    (1 to n).foldLeft(arg) { (acc, _) =>
      f(acc)
    }

  def nextInt(n: Int) = n * n + 1

  def nextNumber[N](n: N)(implicit numericOps: Numeric[N]) =
    numericOps.plus(numericOps.times(n, n), numericOps.one)

  def main(args: Array[String]): Unit = {
    println("applyNMulti(3)(2, nextInt): " + applyNMulti(3)(2, nextInt))
    println("applyNCurried(3)(2)(nextInt): " + applyNCurried(3)(2)(nextInt))
    // ビルドエラー: could not find implicit value for parameter numericOps: Numeric[N]
    // curry化した関数に対して、引数リスト内の引数に対して型推論がうまくいかないため、ここの引数を設定する必要がある
    // println(applyNMulti(3)(2.0, nextNumber))
    println("applyNMulti(3)(2.0, nextNumber): could not find implicit value for parameter numericOps: Numeric[N]")
    println("applyNMulti[Double](3)(2.0, nextNumber): " + applyNMulti[Double](3)(2.0, nextNumber)) // ジェネリック型を指定すればsbtでbuildは通る
    println("applyNMulti(3)(2.0, nextNumber[Double]): " + applyNMulti(3)(2.0, nextNumber[Double])) // ジェネリック型を指定すればsbtでbuildは通る
    println("applyNCurried(3)(2.0)(nextNumber): " + applyNCurried(3)(2.0)(nextNumber)) //IntelliJではエラー出てるけど、sbtでbuildは通る(Why?)
  }
}
