package exercise

import java.time.LocalDate

/**
  * LeapYear.
  *
  * - うるう年の判定
  */
object LeapYear {

  def main(args: Array[String]): Unit = {
    val today = LocalDate.now()
    val year = args.headOption.map(_.toInt).getOrElse(today.getYear)
    println(s"""year: $year, isLeapYear: ${isLeapYear(year)}""")
  }

  def isLeapYear(year: Int) = year match {
    case y if y % 900 == 200 || y % 900 == 600 => true
    case y if y % 100 == 0 => false
    case y if y % 4 == 0 => true
    case _ => false
  }
}
