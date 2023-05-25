package study.project.pokelytics.repositories

import POKE_API_POKEMONS_URL
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import study.project.pokelytics.api.getUrlObject
import study.project.pokelytics.api.getUrlObjectReplace
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.api.models.PokemonExtraInfo
import study.project.pokelytics.api.models.pages.BasePage
import study.project.pokelytics.api.models.pages.PaginationRange
import study.project.pokelytics.api.models.responses.SpecieResponse
import java.net.URL

class PokemonRepository {
    private fun getResponseFromURL(url: URL): BasePage {
        return getUrlObjectReplace(url, BasePage::class.java)
    }

    fun getPokemonFromURL(paginationRange: PaginationRange): Flow<List<Pokemon>> {
        val url = POKE_API_POKEMONS_URL + "?limit=${paginationRange.count}&offset=${paginationRange.from}"
        val response =
            try {
                getResponseFromURL(URL(url))
            } catch (e: Exception) {
                return flowOf(listOf())
            }
        val result = response.results.map {
            getUrlObjectReplace(URL(it.url), Pokemon::class.java)
        }
        return flowOf(result)
    }

    fun getPokemonExtraInfo(params: Pokemon): Flow<Pokemon> {

        val species = getUrlObject(URL(params.species?.url?.replace("_", "-") ?: ""), SpecieResponse::class.java)
        val newPokemon = params.copy(extraInfo = PokemonExtraInfo(species = species))
        return flowOf(newPokemon)
    }
}