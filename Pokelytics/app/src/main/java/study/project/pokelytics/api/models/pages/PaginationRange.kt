package study.project.pokelytics.api.models.pages

data class PaginationRange(
    var from: Int = 0,
    var count: Int = 40,
) {
    fun next() {
        from += count
    }
}