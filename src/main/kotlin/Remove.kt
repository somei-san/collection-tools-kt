/** [elementsToRemove] の要素のキーを持つ [this] の要素を削除して、残りの要素を返します */
fun <T, KeyT> Collection<T>.removeBy(elementsToRemove: Collection<T>, keySelector: (T) -> KeyT): List<T> {
    val otherKeys = elementsToRemove.map { keySelector(it) }.toSet()
    return this.filterNot { keySelector(it) in otherKeys }
}

/** [keysToRemove] の要素のキーを持つ [this] の要素を削除して、残りの要素を返します */
fun <T, KeyT> Collection<T>.removeBy(keysToRemove: Collection<KeyT>, keySelector: (T) -> KeyT): List<T> {
    val otherKeys = keysToRemove.toSet()
    return this.filterNot { keySelector(it) in otherKeys }
}