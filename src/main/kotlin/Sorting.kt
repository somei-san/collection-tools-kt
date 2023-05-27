
/** [this] がソートされていたら true を返します */
inline fun <reified T : Comparable<T>> List<T>.isSorted(): Boolean =
    this.zipWithNext { a, b -> a.compareTo(b) }.all { it <= 0 }