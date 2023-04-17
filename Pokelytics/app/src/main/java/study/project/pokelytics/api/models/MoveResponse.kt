package study.project.pokelytics.api.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.api.models.responses.ItemResponse

data class MoveResponse(

    @SerializedName("accuracy") var accuracy: Int? = null,
    @SerializedName("damage_class") var damageClass: ItemResponse? = ItemResponse(),
    @SerializedName("effect_chance") var effectChance: String? = null,
    @SerializedName("effect_changes") var effectChanges: ArrayList<EffectChanges> = arrayListOf(),
    @SerializedName("effect_entries") var effectEntries: ArrayList<EffectEntries> = arrayListOf(),
    @SerializedName("generation") var generation: ItemResponse? = ItemResponse(),
    @SerializedName("id") var id: Int? = null,
    @SerializedName("learned_by_pokemon") var learnedByPokemon: ArrayList<ItemResponse> = arrayListOf(),
    @SerializedName("machines") var machines: ArrayList<Machines> = arrayListOf(),
    @SerializedName("name") var name: String? = null,
    @SerializedName("power") var power: Int? = null,
    @SerializedName("pp") var pp: Int? = null,
    @SerializedName("priority") var priority: Int? = null,
    @SerializedName("stat_changes") var statChanges: ArrayList<StatChanges> = arrayListOf(),
    @SerializedName("target") var target: ItemResponse? = ItemResponse(),
    @SerializedName("type") var type: ItemResponse? = ItemResponse(),

    )