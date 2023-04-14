package study.project.pokelytics.viewholders

import androidx.core.view.isVisible
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.databinding.PokemonListItemBinding

class PokemonViewHolder(
    private val binding: PokemonListItemBinding,
    val onClick: (Pokemon) -> Unit,
) : BaseViewHolder<Pokemon>(binding.root){
    override fun bind(item: Pokemon) {
        binding.apply {
            root.setOnClickListener { onClick(item) }
            name.text = item.name
            item.id.toString().let {
                when (it.length) {
                    1 -> id.text = "#00$it"
                    2 -> id.text = "#0$it"
                    else -> id.text = "#$it"
                }
            }
            primaryType.text = item.types[0].type?.name ?: ""
            if (item.types.size > 1) {
                secondaryType.text = item.types[1].type?.name ?: ""
                secondaryType.isVisible = true
            } else {
                secondaryType.isVisible = false
            }
            //binding.pokemonContainer.background = getBackground() TODO - Add background depending on species
        }
    }


}