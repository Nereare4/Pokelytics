package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse

data class EffectChanges (

    @SerializedName("effect_entries" ) var effectEntries : ArrayList<EffectEntries> = arrayListOf(),
    @SerializedName("version_group"  ) var versionGroup  : ItemResponse?            = ItemResponse()

)
