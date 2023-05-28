package study.project.pokelytics.viewholders

import android.annotation.SuppressLint
import androidx.core.view.isVisible
import study.project.pokelytics.R
import study.project.pokelytics.api.model.Pokemon
import study.project.pokelytics.databinding.PokemonListItemBinding
import study.project.pokelytics.event.observeEvent
import study.project.pokelytics.fragments.main.PokemonListFragment
import study.project.pokelytics.setImageToUrl
import java.util.Locale

class PokemonViewHolder(
    private val binding: PokemonListItemBinding,
    private val pokemonInterface : PokemonListFragment.PokemonViewHolderInterface
) : BaseViewHolder<Pokemon>(binding.root) {

    private val moreInfoViewModel = pokemonInterface.createMoreInfoViewModel()

    override fun bind(item: Pokemon) {
        drawItem(item)
        moreInfoViewModel.pokemon.observeEvent(this) {
            loadExtraInfo(it)
        }
        moreInfoViewModel.getPokemonExtraInfo(item)
    }

    @SuppressLint("SetTextI18n")
    private fun drawItem(item: Pokemon) {
        binding.apply {
            root.setOnClickListener {
                pokemonInterface.onPokemonClick(item)
            }
            name.text = item.name
            item.id.toString().let {
                when (it.length) {
                    1 -> id.text = "#00$it"
                    2 -> id.text = "#0$it"
                    else -> id.text = "#$it"
                }
            }
            primaryType.text = item.types[0].type.name
            if (item.types.size > 1) {
                secondaryType.text = item.types[1].type.name
                secondaryType.isVisible = true
            } else {
                secondaryType.isVisible = false
            }
            binding.image.setImageToUrl(
                item.sprites.other?.officialArtwork?.frontDefault ?: "",)
        }
    }

    private fun loadExtraInfo(item: Pokemon) {
        binding.apply {
            binding.pokemonContainer.setBackgroundResource(getBackground(item.extraInfo?.species?.color?.name ?: ""))
        }
    }

    private fun getBackground(color: String): Int {
        return when (color.lowercase(Locale.ROOT)) {
            "black" -> R.drawable.pokemon_black
            "blue" -> R.drawable.pokemon_blue
            "brown" -> R.drawable.pokemon_brown
            "gray" -> R.drawable.pokemon_gray
            "pink" -> R.drawable.pokemon_pink
            "purple" -> R.drawable.pokemon_purple
            "red" -> R.drawable.pokemon_red
            "white" -> R.drawable.pokemon_white
            "yellow" -> R.drawable.pokemon_yellow
            else -> R.drawable.pokemon_green
        }
    }
}