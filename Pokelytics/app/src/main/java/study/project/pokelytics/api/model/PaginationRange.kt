package study.project.pokelytics.api.model

data class PaginationRange(
    var from: Int = 0,
    var count: Int = 40,
) {
    fun next() {
        from += count
    }
}