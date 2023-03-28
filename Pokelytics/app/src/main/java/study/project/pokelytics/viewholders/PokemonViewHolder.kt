package study.project.pokelytics.viewholders

import android.view.View
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.databinding.PokemonViewHolderBinding

class PokemonViewHolder(
    containerView: View,
    val binding: PokemonViewHolderBinding,
    val onClick: (Pokemon) -> Unit,
) : BaseViewHolder<Pokemon>(containerView){
    override fun bind(item: Pokemon) {
        binding.apply {
            root.setOnClickListener { onClick(item) }
        }
    }
}