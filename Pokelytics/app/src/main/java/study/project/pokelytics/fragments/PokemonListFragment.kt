package study.project.pokelytics.fragments

import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.adapters.PokemonListAdapter
import study.project.pokelytics.databinding.FragmentPokemonListBinding
import study.project.pokelytics.viewmodels.PokemonListViewModel
import study.project.pokelytics.viewmodels.ViewState

class PokemonListFragment : FragmentBase<FragmentPokemonListBinding>() {

    private val viewModel: PokemonListViewModel by viewModel()

    override fun bindViewModel() {
        binding.apply {
            this.lifecycleOwner = this@PokemonListFragment
        }
    }

    override fun initializeView() {
        PokemonListAdapter {  }.apply {

        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshState(ViewState.IDLE)
    }

    override fun getResourceLayout(): Int = R.layout.fragment_pokemon_list

    override fun subscribe() {
        viewModel.state.observe(this) {
            when (it) {
                ViewState.IDLE -> viewModel.getPokemons(0)
                else -> {}
            }
        }
    }
}