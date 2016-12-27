package puzzle

import collection.immutable.HashSet

/**
  * Puzzle10.
  *
  * - Classのイコールについて
  */
object Puzzle10 {

  def main(args: Array[String]): Unit = {
    val countriesInst = HashSet(newSwitzInst)
    println(countriesInst.iterator contains newSwitzInst)
    println(countriesInst contains newSwitzInst)

    val countriesDecl = HashSet(newSwitzDecl)
    println(countriesDecl.iterator contains newSwitzDecl)
    println(countriesDecl contains newSwitzDecl)
  }

  // instance生成時にtraitをmixin
  def newSwitzInst = new Country("CH") with TraceHashCode

  def newSwitzDecl = new CountryWithTrace("CH")
}

trait TraceHashCode {
  override def hashCode(): Int = {
    println(s"""TRACE: In HashCode for $this""")
    super.hashCode()
  }
}

case class Country(isoCode: String)

// 宣言時にtraitをmixin
case class CountryWithTrace(isoCode: String) extends TraceHashCode
