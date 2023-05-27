/**
 * [this] の各要素に対し [addingElements] の各要素で 追加 or 上書き します。
 *
 * [keySelector] で指定された [KeyT] の値が [this] にすでに存在すれば上書き、存在しなければ追加します。
 * */
inline fun <T, KeyT> Collection<T>.upsertBy(addingElements: Collection<T>, keySelector: (T) -> KeyT): List<T> =
    (this.associateBy(keySelector) + addingElements.associateBy(keySelector)).map { it.value }

/**
 * [this] に対し [addingElements] を 追加 します。
 *
 * [keySelector] で指定された [KeyT] の値が [this] にすでに存在すれば追加しません。
 * */
inline fun <T, KeyT> Collection<T>.insertBy(addingElements: Collection<T>, keySelector: (T) -> KeyT): List<T> {
    // IF的にこの関数は戻値の順番を保証しないが、感覚的にはレシーバーの要素が先にこないとキモいので、そうなるようにしている
    val receiverKeys = this.map { keySelector(it) }.toSet()
    return this.toList() + addingElements.filter { e -> receiverKeys.contains(keySelector(e)).not() }
}

/**
 * [this] の各要素に対し [addingElements] の各要素で 上書き します。
 *
 * [keySelector] で指定された [KeyT] の値が [this] にすでに存在しなければ例外をスローします。
 * */
inline fun <T, KeyT> Collection<T>.updateBy(addingElements: Collection<T>, keySelector: (T) -> KeyT): List<T> {
    if (this.hasDifferenceBy(addingElements, keySelector)) throw NoSuchElementException()
    return this.upsertBy(addingElements, keySelector)
}