/**
 * [this] と [compared] の集合をとって、差分があれば true を返します。
 * */
fun <T> Collection<T>.hasDifferenceTo(compared: Collection<T>): Boolean = this.difference(compared).any()


/**
 * [this] と [compared] に対し [keySelector] で指定されたキーの集合をとって、差分があれば true を返します。
 * */
inline fun <T, KeyT> Collection<T>.hasDifferenceTo(compared: Collection<T>, keySelector: (T) -> KeyT): Boolean {
    val receiverKeys = this.map { keySelector(it) }
    val comparedKeys = compared.map { keySelector(it) }
    return receiverKeys.difference(comparedKeys).any()
}

/**
 * [keySelector] で指定されたキーにおいて、[elements] のすべてのキーが [this] のキーに含有されていれば true を返します。
 * */
inline fun <T, KeyT> Collection<T>.containsAll(elements: Collection<T>, keySelector: (T) -> KeyT): Boolean =
    this.map { keySelector(it) }.containsAll(elements.map { keySelector(it) })

/** 差集合を返します */
fun <T> Set<T>.difference(other: Set<T>): Set<T> = this.minus(other) + other.minus(this)

/** 差集合を返します */
fun <T> Collection<T>.difference(other: Collection<T>): Set<T> = this.toSet().difference(other.toSet())