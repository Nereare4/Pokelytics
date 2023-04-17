package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse


data class Abilities(

    @SerializedName("ability") var ability: ItemResponse? = ItemResponse(),
    @SerializedName("is_hidden") var isHidden: Boolean? = null,
    @SerializedName("slot") var slot: Int? = null

)