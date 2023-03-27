package study.project.pokelytics.repositories

import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.api.models.pages.BasePage
import study.project.pokelytics.api.getUrlObjectReplace
import java.net.URL

class PokemonRepository {
    fun getResponseFromURL(url: URL): BasePage {
        return getUrlObjectReplace(url, BasePage::class.java)
    }

    fun getPokemonFromURL(url: URL): Pokemon {
        return try {
            getUrlObjectReplace(url, Pokemon::class.java)
        } catch (e: Exception) {
            Pokemon()
        }
    }
}