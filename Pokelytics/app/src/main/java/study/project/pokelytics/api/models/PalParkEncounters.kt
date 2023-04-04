package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse

data class PalParkEncounters (

    @SerializedName("area"       ) var area      : ItemResponse? = ItemResponse(),
    @SerializedName("base_score" ) var baseScore : Int?  = null,
    @SerializedName("rate"       ) var rate      : Int?  = null

)