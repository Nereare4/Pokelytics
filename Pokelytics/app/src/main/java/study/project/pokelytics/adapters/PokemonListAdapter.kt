package study.project.pokelytics.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.databinding.PokemonListItemBinding
import study.project.pokelytics.viewholders.PokemonViewHolder

class PokemonListAdapter(
    private val onClick: (Pokemon) -> Unit,
) : BaseRecyclerAdapter<Pokemon, PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = PokemonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding, onClick)
    }
}