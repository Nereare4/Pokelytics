package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName

data class Varieties (

    @SerializedName("is_default" ) var isDefault : Boolean? = null,
    @SerializedName("pokemon"    ) var pokemon   : Pokemon? = Pokemon()

)