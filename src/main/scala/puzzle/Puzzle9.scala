package puzzle

/**
  * Puzzle9.
  *
  * - 初期化について（循環参照、遅延初期化）
  * - 循環参照はできるだけ避ける。やむをえない場合は値の初期化の挙動を把握する
  */
object Puzzle9 {

  def main(args: Array[String]): Unit = {
    val result = if (Math.random > 0.5) XY.X.value else XY.Y.value
    println("XY: " + result)
    println("XY.X: " + XY.X.value)
    println("XY.Y: " + XY.Y.value)
    try {
      if (Math.random > 0.5) XY2.xvalue else XY2.yvalue
    } catch {
      case e: StackOverflowError => println("XY2(lazy val): " + e.toString)
    }
    try {
      val xy3 = new XY3()
      if (Math.random > 0.5) xy3.X.value else xy3.Y.value
    } catch {
      case e: StackOverflowError =>
        println("XY3(class definition): " + e.toString)
    }
    val result4 = if (Math.random > 0.5) XY4.xvalue else XY4.yvalue
    println("XY4: " + result4)
    println("XY4.X: " + XY4.xvalue)
    println("XY4.Y: " + XY4.yvalue)
    val result5 = if (Math.random > 0.5) XY5.xvalue else XY5.yvalue
    println("XY5: " + result5)
    println("XY5.X: " + XY5.xvalue)
    println("XY5.Y: " + XY5.yvalue)
  }
}

/**
  * - 言語仕様でオブジェクトに定義した値(value)は遅延初期化される(lazyとほぼ同じ)
  * - 値はオブジェクトが定義されたタイミングではなく、最初にアクセスされたタイミングで初期化される
  * - JVMの仕様で複数回初期化できない(無限ループ防止)ため、その場合はIntのdefault値が設定される
  * - XY4が初期化されるとxvalueが初期化されれる。
  *   yvalueは初期化されていないので、defaultの0を返してxvalueは1になり、yvalueは2に成る
  *   定義の順番を入れ替えれば、xvalueとyvalueの値が入れ替わる
  */
object XY {
  object X {
    val value: Int = Y.value + 1
  }
  object Y {
    val value: Int = X.value + 1
  }
}

/**
  * - lazyを利用した場合はJVMの無限ループ防止されないため、java.lang.StackOverflowErrorが発生する
  */
object XY2 {
  lazy val xvalue: Int = yvalue + 1
  lazy val yvalue: Int = xvalue + 1
}

/**
  * - Classで定義した場合はJVMの無限ループ防止されないため、java.lang.StackOverflowErrorが発生する
  */
class XY3 {
  object X {
    val value: Int = Y.value + 1
  }
  object Y {
    val value: Int = X.value + 1
  }
}

/**
  * - XY4が初期化されるとxvalueが初期化されれる。
  *   yvalueは初期化されていないので、defaultの0を返してxvalueは1になり、yvalueは2に成る
  */
object XY4 {
  lazy val xvalue: Int = yvalue + 1
  val yvalue: Int = xvalue + 1
}

/**
  * lazy を外してもうまくいくが、コンパイラがxvalueについて警告を出す(Reference to uninitialized value yvalue)
  */
object XY5 {
  val xvalue: Int = yvalue + 1
  val yvalue: Int = xvalue + 1
}
