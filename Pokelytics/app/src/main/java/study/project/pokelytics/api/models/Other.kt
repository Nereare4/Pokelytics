package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Other(

    @SerializedName("dream_world") var dreamWorld: DreamWorld? = DreamWorld(),
    @SerializedName("home") var home: Home? = Home(),
    @SerializedName("official_artwork") var official_artwork: Official_artwork? = Official_artwork()

)