package study.project.pokelytics.usecases

import kotlinx.coroutines.flow.Flow
import study.project.pokelytics.api.datasources.LocationDataSource
import study.project.pokelytics.api.model.Location
import study.project.pokelytics.api.model.PaginationRange

class GetLocationUseCase(
    private val locationDataSource: LocationDataSource
) : FlowUseCase<List<Location>, PaginationRange>() {

    override suspend fun execute(params: PaginationRange): Flow<List<Location>> {
        return locationDataSource.getLocationFromPage(params)
    }
}