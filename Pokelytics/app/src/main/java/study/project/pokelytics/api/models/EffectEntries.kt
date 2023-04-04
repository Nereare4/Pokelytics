package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName

data class EffectEntries(

    @SerializedName("effect") var effect: String? = null,
    @SerializedName("short_effect") var shortEffect: String? = null

)