package puzzle

/**
  * Exercise4.
  * - 多段の継承
  */
object Exercise4 {
  def main(args: Array[String]): Unit = {
    new C()
  }
}

trait A {
  val foo: Int
  val bar = 10
  def barDef = 10
  lazy val barLazy = 10
  val barEarlyDefinition = 10
  println(s"""In A: foo: $foo, bar: $bar, barDef: $barDef, barLazy: $barLazy, barEarlyDefinition: $barEarlyDefinition""")
}

class B extends A {
  val foo = 25
  println(s"""In B: foo: $foo, bar: $bar, barDef: $barDef, barLazy: $barLazy, barEarlyDefinition: $barEarlyDefinition""")
}

class C extends {
  // 事前初期化fieldを利用することでSuperClass.barEarlyDefinitionにも適用される
  override val barEarlyDefinition = 99
} with B {
  // ここでoverrideすることでSuperClassのbarの初期化が無効化(default: 0)される
  override val bar: Int = 99

  // どのクラスでもオーバーライドされた定義を呼び出す(呼び出すたびに評価する)
  override def barDef = 99

  // 定義時に初期化ではなく、最初にアクセスされたタイミングで初期化
  override lazy val barLazy: Int = 99
  println(s"""In C: foo: $foo, bar: $bar, barDef: $barDef", barLazy: $barLazy, barEarlyDefinition: $barEarlyDefinition""")
}