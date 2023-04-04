package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Official_artwork(

    @SerializedName("front_default") var frontDefault: String? = null

)