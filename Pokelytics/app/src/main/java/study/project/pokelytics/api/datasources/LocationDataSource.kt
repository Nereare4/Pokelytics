package study.project.pokelytics.api.datasources

import kotlinx.coroutines.flow.Flow
import study.project.pokelytics.api.client.PokeApiClient
import study.project.pokelytics.api.model.Location
import study.project.pokelytics.models.LocationList

class LocationDataSource(
    val remote: PokeApiClient
) {

    fun getLocationFromPage(locationList: LocationList): Flow<List<Location>> =
        remote.getLocationList(locationList)

}