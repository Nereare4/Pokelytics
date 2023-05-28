package study.project.pokelytics.api.model

import java.lang.Integer.min

data class PaginationRange(
    var from: Int = 0,
    var count: Int = 40,
    var stop: Boolean = false
) {
    fun next() {
        if (count == MAX) {
            stop = true
            return
        }
        from = min(from + count, MAX)
    }

    companion object {
        const val MAX = 1010
    }
}