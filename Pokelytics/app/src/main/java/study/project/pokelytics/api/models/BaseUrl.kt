package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName

data class BaseUrl(

    @SerializedName("url") var url: String? = null
)