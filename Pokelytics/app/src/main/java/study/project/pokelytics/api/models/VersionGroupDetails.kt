package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse


data class VersionGroupDetails(

    @SerializedName("level_learned_at") var levelLearnedAt: Int? = null,
    @SerializedName("move_learn_method") var moveLearnMethod: ItemResponse? = ItemResponse(),
    @SerializedName("version_group") var versionGroup: ItemResponse? = ItemResponse()

)