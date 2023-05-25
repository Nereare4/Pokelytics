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
        return try {
            getUrlObjectReplace(url, BasePage::class.java)
        } catch (e: Exception) {
            BasePage()
        }
    }

    fun getPokemonFromURL(paginationRange: PaginationRange): Flow<List<Pokemon>> {
        val url = POKE_API_POKEMONS_URL + "?limit=${paginationRange.count}&offset=${paginationRange.from}"
        val response = getResponseFromURL(URL(url))
        val result = response.results.map {
            try {
                getUrlObjectReplace(URL(it.url), Pokemon::class.java)
            } catch (e: Exception) {
                Pokemon()
            }
        }
        return flowOf(result)
    }

    fun getPokemonExtraInfo(params: Pokemon): Flow<Pokemon> {

        val species = getUrlObject(URL(params.species?.url?.replace("_", "-") ?: ""), SpecieResponse::class.java)
        val newPokemon = params.copy(extraInfo = PokemonExtraInfo(species = species))
        return flowOf(newPokemon)
    }
}