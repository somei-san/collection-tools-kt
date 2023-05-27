/**
 * 要素が重複していたら true を返します。
 * */
inline fun <reified T> Collection<T>.hasDuplicate(): Boolean {
    val set = mutableSetOf<T>()
    this.forEach { if (set.add(it).not()) return true }
    return false
}

/**
 * [keySelector] で指定された要素が重複していたら true を返します。
 * */
inline fun <reified T, reified R> Collection<T>.hasDuplicateBy(keySelector: (T) -> R): Boolean {
    val set = mutableSetOf<R>()
    this.forEach { if (set.add(keySelector(it)).not()) return true }
    return false
}

