package study.project.pokelytics.repositories

import study.project.pokelytics.api.models.ColorResponse
import study.project.pokelytics.api.models.pages.BasePage
import study.project.pokelytics.api.getUrlObject
import java.net.URL

class ColorRepository {
    fun getAllColors(url: URL): BasePage {
        return getUrlObject(url, BasePage::class.java)
    }

    fun getPokemonFromColor(url: URL): ColorResponse {
        return try {
            getUrlObject(url, ColorResponse::class.java)
        } catch (e: Exception) {
            ColorResponse()
        }
    }
}