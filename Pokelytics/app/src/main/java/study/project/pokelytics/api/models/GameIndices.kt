package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse


data class GameIndices(

    @SerializedName("game_index") var gameIndex: Int? = null,
    @SerializedName("version") var version: ItemResponse? = ItemResponse()

)