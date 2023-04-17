package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName


data class Generation_iii(

    @SerializedName("emerald") var emerald: Emerald? = Emerald(),
    @SerializedName("firered_leafgreen") var firered_leafgreen: Firered_leafgreen? = Firered_leafgreen(),
    @SerializedName("ruby_sapphire") var ruby_sapphire: Ruby_sapphire? = Ruby_sapphire()

)