package study.project.pokelytics.repositories

import study.project.pokelytics.api.models.pages.BasePage
import study.project.pokelytics.api.models.responses.SpecieResponse
import study.project.pokelytics.api.getUrlObject
import study.project.pokelytics.api.getUrlObjectReplace
import java.net.URL

class SpeciesRepository {

    fun getResponseFromURL(url: URL): BasePage {
        return getUrlObjectReplace(url, BasePage::class.java)
    }
    fun getColorFromUrl(url: URL): SpecieResponse {
        return try {
            getUrlObject(url, SpecieResponse::class.java)
        } catch (e: Exception) {
            SpecieResponse()
        }
    }
}