package study.project.pokelytics.api.models.responses

import com.google.gson.annotations.SerializedName

data class ItemResponse(

    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)