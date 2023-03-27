package study.project.pokelytics.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import study.project.pokelytics.api.getUrlObjectReplace
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.api.models.pages.BasePage
import java.net.URL

class PokemonRepository {
    fun getResponseFromURL(url: URL): BasePage {
        return getUrlObjectReplace(url, BasePage::class.java)
    }

    fun getPokemonFromURL(paginationRange: Int): Flow<List<Pokemon>> {
        return try {
            flowOf(

            )
        } catch (e: Exception) {
            flowOf()
        }
    }
}