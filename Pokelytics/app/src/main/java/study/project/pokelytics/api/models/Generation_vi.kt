package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Generation_vi(

    @SerializedName("omegaruby_alphasapphire") var omegaruby_alphasapphire: Omegaruby_alphasapphire? = Omegaruby_alphasapphire(),
    @SerializedName("x_y") var x_y: X_y? = X_y()

)