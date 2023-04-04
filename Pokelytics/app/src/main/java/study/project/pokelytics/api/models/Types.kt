package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse


data class Types(

    @SerializedName("slot") var slot: Int? = null,
    @SerializedName("type") var type: ItemResponse? = ItemResponse()

)