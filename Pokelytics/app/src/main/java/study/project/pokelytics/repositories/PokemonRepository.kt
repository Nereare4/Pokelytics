package study.project.pokelytics.repositories

import POKE_API_POKEMONS_URL
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import study.project.pokelytics.api.getUrlObjectReplace
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.api.models.pages.BasePage
import study.project.pokelytics.api.models.pages.PaginationRange
import java.net.URL

class PokemonRepository {
    fun getResponseFromURL(url: URL): BasePage {
        return getUrlObjectReplace(url, BasePage::class.java)
    }

    fun getPokemonFromURL(paginationRange: PaginationRange): Flow<List<Pokemon>> {
        val url = POKE_API_POKEMONS_URL + "?limit=${paginationRange.count}&offset=${paginationRange.from}"
        val response = getResponseFromURL(URL(url))
        val result = response.results.map {
            Log.d("POKELYTICS", "${it.url}")
            getUrlObjectReplace(URL(it.url), Pokemon::class.java)
        }
        return flowOf(result)
    }
}