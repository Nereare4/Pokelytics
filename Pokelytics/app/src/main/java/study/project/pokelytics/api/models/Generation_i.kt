package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Generation_i(

    @SerializedName("red_blue") var red_blue: Red_blue? = Red_blue(),
    @SerializedName("yellow") var yellow: Yellow? = Yellow()

)