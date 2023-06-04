package study.project.pokelytics.api.datasources

import kotlinx.coroutines.flow.Flow
import study.project.pokelytics.api.client.PokeApiClient
import study.project.pokelytics.api.model.Location
import study.project.pokelytics.api.model.PaginationRange

class LocationDataSource(
    val remote: PokeApiClient
) {

    fun getLocationFromPage(paginationRange: PaginationRange): Flow<List<Location>> =
        remote.getLocationList(paginationRange.from, paginationRange.count)

}