package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Generation_ii(

    @SerializedName("crystal") var crystal: Crystal? = Crystal(),
    @SerializedName("gold") var gold: Gold? = Gold(),
    @SerializedName("silver") var silver: Silver? = Silver()

)