package study.project.pokelytics.repositories

import study.project.pokelytics.api.models.MoveResponse
import study.project.pokelytics.api.models.pages.BasePage
import study.project.pokelytics.api.getUrlObject
import java.net.URL

class MoveRepository {
    fun getResponseFromURL(url: URL): BasePage {
        return getUrlObject(url, BasePage::class.java)
    }

    fun getMoveFromURL(url: URL): MoveResponse {
        return try {
            getUrlObject(url, MoveResponse::class.java)
        } catch (e: Exception) {
            MoveResponse()
        }
    }
}