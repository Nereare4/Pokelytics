package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Versions(

    @SerializedName("generation_i") var generation_i: Generation_i? = Generation_i(),
    @SerializedName("generation_ii") var generation_ii: Generation_ii? = Generation_ii(),
    @SerializedName("generation_iii") var generation_iii: Generation_iii? = Generation_iii(),
    @SerializedName("generation_iv") var generation_iv: Generation_iv? = Generation_iv(),
    @SerializedName("generation_v") var generation_v: Generation_v? = Generation_v(),
    @SerializedName("generation_vi") var generation_vi: Generation_vi? = Generation_vi(),
    @SerializedName("generation_vii") var generation_vii: Generation_vii? = Generation_vii(),
    @SerializedName("generation_viii") var generation_viii: Generation_viii? = Generation_viii()

)