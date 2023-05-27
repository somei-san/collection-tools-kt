/** [this] の要素の数が 2 以上であれば true を返します。*/
fun <T> Iterable<T>.many(): Boolean {
    val iterator = this.iterator()
    if (iterator.hasNext().not()) return false
    iterator.next()
    if (iterator.hasNext().not()) return false
    return true
}

/** [this] の要素のうち [predicate] に適合する要素の数が 2 以上であれば true を返します。*/
inline fun <T> Iterable<T>.many(predicate: (T) -> Boolean): Boolean {
    var hasFirst = false
    this.forEach {
        if (predicate(it))
            if (hasFirst.not()) hasFirst = true
            else return true
    }
    return false
}