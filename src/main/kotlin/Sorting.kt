/** [this] がソートされていたら true を返します */
fun <T : Comparable<T>> List<T>.isSorted(): Boolean =
    this.zipWithNext { a, b -> a.compareTo(b) }.all { it <= 0 }