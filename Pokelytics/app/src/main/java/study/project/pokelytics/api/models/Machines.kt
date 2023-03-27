package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse

data class Machines (

    @SerializedName("machine"       ) var machine      : Machine?      = Machine(),
    @SerializedName("version_group" ) var versionGroup : ItemResponse? = ItemResponse()

)
