package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse


data class HeldItems(

    @SerializedName("item") var item: ItemResponse? = ItemResponse(),
    @SerializedName("version_details") var versionDetails: ArrayList<VersionDetails> = arrayListOf()

)