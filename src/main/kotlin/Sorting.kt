import javax.xml.crypto.KeySelector

/** [this] がソートされていたら true を返します */
fun <T : Comparable<T>> List<T>.isSorted(): Boolean =
    this.asSequence().zipWithNext { a, b -> a.compareTo(b) }.all { it <= 0 }

/** [this] が [keySelector] で指定されたキーでソートされていたら true を返します */
fun <T, KeyT : Comparable<KeyT>> List<T>.isSortedBy(keySelector: (T) -> KeyT): Boolean =
    this.asSequence().map { keySelector(it) }.zipWithNext { a, b -> a.compareTo(b) }.all { it <= 0 }