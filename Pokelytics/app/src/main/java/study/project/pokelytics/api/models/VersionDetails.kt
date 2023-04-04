package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse


data class VersionDetails(

    @SerializedName("rarity") var rarity: Int? = null,
    @SerializedName("version") var version: ItemResponse? = ItemResponse()

)