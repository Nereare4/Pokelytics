package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse

data class StatChanges (

    @SerializedName("change" ) var change : Int?  = null,
    @SerializedName("stat"   ) var stat   : ItemResponse? = ItemResponse()

)
