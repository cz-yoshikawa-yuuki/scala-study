package exercise1

/**
  * TransposedMatrix.
  *
  * - 転置行列
  */
object TransposedMatrix {

  def main(args: Array[String]): Unit = {
    val size = args.headOption.map(_.toInt).getOrElse(3)
    val matrix = createMatrix(size)
    println("input matrix:")
    println(showMatrix(matrix))
    println("=== transposed ===")
    println(showMatrix(transposed(matrix)))
  }

  def createMatrix(size: Int): Seq[Seq[Int]] =
    (1 to size * size).grouped(size).toSeq

  def transposed(matrix: Seq[Seq[Int]]): Seq[Seq[Int]] =
    matrix.zipWithIndex.map {
      case (record, index) =>
        for (i <- matrix.indices)
          yield matrix(i)(index) // matrix.indices: Range
    }

  def showMatrix(matrix: Seq[Seq[Int]]): String =
    matrix.foldLeft("") { (str, row) =>
      str + s"""[${row.map(i => f"""$i%4s""").mkString(" ")}]\n"""
    }
}
