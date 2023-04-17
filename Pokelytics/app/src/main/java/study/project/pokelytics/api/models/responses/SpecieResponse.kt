package study.project.pokelytics.api.models.responses

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.BaseUrl
import study.project.pokelytics.api.models.PalParkEncounters
import study.project.pokelytics.api.models.Varieties

data class SpecieResponse(

    @SerializedName("base_happiness") var baseHappiness: Int? = null,
    @SerializedName("capture_rate") var captureRate: Int? = null,
    @SerializedName("color") var color: ItemResponse? = ItemResponse(),
    @SerializedName("egg_groups") var eggGroups: ArrayList<ItemResponse> = arrayListOf(),
    @SerializedName("evolution_chain") var evolutionChain: BaseUrl? = BaseUrl(),
    @SerializedName("evolves_from_species") var evolvesFromSpecies: ItemResponse? = ItemResponse(),
    @SerializedName("form_descriptions") var formDescriptions: ArrayList<ItemResponse> = arrayListOf(),
    @SerializedName("forms_switchable") var formsSwitchable: Boolean? = null,
    @SerializedName("gender_rate") var genderRate: Int? = null,
    @SerializedName("generation") var generation: ItemResponse? = ItemResponse(),
    @SerializedName("growth_rate") var growthRate: ItemResponse? = ItemResponse(),
    @SerializedName("habitat") var habitat: ItemResponse? = ItemResponse(),
    @SerializedName("has_gender_differences") var hasGenderDifferences: Boolean? = null,
    @SerializedName("hatch_counter") var hatchCounter: Int? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("is_baby") var isBaby: Boolean? = null,
    @SerializedName("is_legendary") var isLegendary: Boolean? = null,
    @SerializedName("is_mythical") var isMythical: Boolean? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("order") var order: Int? = null,
    @SerializedName("pal_park_encounters") var palParkEncounters: ArrayList<PalParkEncounters> = arrayListOf(),
    @SerializedName("shape") var shape: ItemResponse? = ItemResponse(),
    @SerializedName("varieties") var varieties: ArrayList<Varieties> = arrayListOf()

)