package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Generation_vii(

    @SerializedName("icons") var icons: Icons? = Icons(),
    @SerializedName("ultra_sun_ultra_moon") var ultra_sun_ultra_moon: Ultra_sun_ultra_moon? = Ultra_sun_ultra_moon()

)