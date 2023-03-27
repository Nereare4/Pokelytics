package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse

data class ColorResponse (

    @SerializedName("id"              ) var id             : Int?                      = null,
    @SerializedName("name"            ) var name           : String?                   = null,
    @SerializedName("pokemon_species" ) var pokemonSpecies : ArrayList<ItemResponse> = arrayListOf()

)