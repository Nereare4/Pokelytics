package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Generation_v(

    @SerializedName("black_white") var black_white: Black_white? = Black_white()

)