/**
 * 要素が重複していたら true を返します。
 * */
inline fun <reified T> Collection<T>.hasDuplicate(): Boolean {
    val set = mutableSetOf<T>()
    this.forEach { if (set.add(it).not()) return true }
    return false
}

/**
 * [keySelector] で指定されたキーが重複していたら true を返します。
 * */
inline fun <reified T, reified KeyT> Collection<T>.hasDuplicateBy(keySelector: (T) -> KeyT): Boolean {
    val set = mutableSetOf<KeyT>()
    this.forEach { if (set.add(keySelector(it)).not()) return true }
    return false
}

