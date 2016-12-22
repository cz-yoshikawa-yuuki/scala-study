package puzzle

/**
  * Exercise3.
  * - Constructorの挙動
  *   1. instanceする際の引数が評価される(事前定義を利用していればこのタイミングで評価)
  *   2. SuperClassのConstructorの挙動
  *   3. SubClassのBodyStatementの実行
  */
object Exercise3 {
  def main(args: Array[String]): Unit = {
    println("instance BMember")
    new BMember("Reader")
    println("instance BConstructor")
    new BConstructor("Reader")
    println("instance BEarlyDef")
    new BEarlyDef("Reader")
  }
}

trait Audience {
  val audience: String
  println("Hello " + audience)
}

/**
  * audienceにaの値が設定される前にSuperClassのConstructor引が呼ばれるので、
  * SuperClass.audienceはnull("Hello null"と出力)
  *
  * @param a audience
  */
class BMember(a: String = "World") extends Audience {
  override val audience: String = a
  println("I repeat: Hello " + audience)
}

/**
  * 引数のaudienceが評価される時点でaudienceは更新されるため
  * SuperClass.audienceはConstructor引数の値
  *
  * @param audience audience
  */
class BConstructor(val audience: String = "World") extends Audience {
  println("I repeat: Hello " + audience)
}

/**
  * fieldの事前定義を使えば、Constructorの引数でaudienceを宣言するのと同じことができる
  *
  * @param a audience
  */
class BEarlyDef(a: String = "World") extends {
  val audience = a
} with Audience {
  println("I repeat: Hello " + audience)
}
