package puzzle

/**
  * Puzzle5.
  * - コレクションサイズの合計(collectionによる結果の違いの例)
  */
object Puzzle5 {
  def main(args: Array[String]): Unit = {
    val lists = List(Set(1, 2), List(3, 4))
    val sets = Set(List(1, 2), Set(3, 4))
    println(s"""lists.sumSize: ${sumSizes(lists)}""")
    println(s"""sets.sumSize: ${sumSizes(sets)}""") // 同じ値を含めることができず、Set(2, 2) => Set(2)になる
    println(s"""sets.toSeq.sumSize: ${sumSizes(sets.toSeq)}""")
    println(s"""lists.toSet.sumSize: ${sumSizes(lists.toSet)}""") // Setに変換した場合は結果が異なる
    println(s"""lists.sumSizesImprove: ${sumSizesImprove(lists)}""")
    println(s"""sets.sumSizesImprove: ${sumSizesImprove(sets)}""")
  }

  def sumSizes(collections: Iterable[Iterable[_]]): Int = {
    collections.map(_.size).sum
  }

  def sumSizesImprove(collections: Iterable[Iterable[_]]): Int = {
    // 外部Collectionの反復処理を避けることができ、適切な結果を返すことができる
    collections.foldLeft(0) { (sumOfSize, collection) =>
      sumOfSize + collection.size
    }
  }
}
