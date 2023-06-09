package study.project.pokelytics.api.datasources

import kotlinx.coroutines.flow.Flow
import study.project.pokelytics.api.client.PokeApiClient
import study.project.pokelytics.api.model.Move
import study.project.pokelytics.api.model.PaginationRange

class MoveDataSource(
    val remote: PokeApiClient
) {

    fun getMoveFromPage(paginationRange: PaginationRange): Flow<List<Move>> =
        remote.getMoveList(paginationRange.from, paginationRange.count)

}