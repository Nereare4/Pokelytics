package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Generation_iv(

    @SerializedName("diamond_pearl") var diamond_pearl: Diamond_pearl? = Diamond_pearl(),
    @SerializedName("heartgold_soulsilver") var heartgold_soulsilver: Heartgold_soulsilver? = Heartgold_soulsilver(),
    @SerializedName("platinum") var platinum: Platinum? = Platinum()

)