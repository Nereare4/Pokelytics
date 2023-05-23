package study.project.pokelytics.fragments.main

import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.adapters.PokemonListAdapter
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.api.models.pages.PaginationRange
import study.project.pokelytics.databinding.FragmentPokemonListBinding
import study.project.pokelytics.fragments.FragmentBase
import study.project.pokelytics.usecases.GetPokemonMoreInfoUseCase
import study.project.pokelytics.viewmodels.MoreInfoViewModel
import study.project.pokelytics.viewmodels.PokemonListViewModel
import study.project.pokelytics.viewmodels.ViewState

class PokemonListFragment : FragmentBase<FragmentPokemonListBinding>() {

    private val viewModel: PokemonListViewModel by viewModel()
    private lateinit var adapter: PokemonListAdapter
    private val layoutManager: LinearLayoutManager = LinearLayoutManager(context)
    private val paginationRange = PaginationRange()
    private val pokemonMoreInfoUseCase: GetPokemonMoreInfoUseCase by inject()

    override fun bindViewModel() {
        binding.apply {
            this.lifecycleOwner = this@PokemonListFragment
        }
    }

    override fun initializeView() {
        adapter = PokemonListAdapter(
            pokemonInterface = createPokemonInterface()
        )

        binding.apply {
            pokemonRecycler.layoutManager = layoutManager
            pokemonRecycler.adapter = adapter
        }
    }

    private fun createPokemonInterface(): PokemonViewHolderInterface {
        return object : PokemonViewHolderInterface {
            override fun onPokemonClick(pokemon: Pokemon) {
               // viewModel.navigateToPokemonDetail(pokemon)
            }

            override fun createMoreInfoViewModel(): MoreInfoViewModel {
                return MoreInfoViewModel(
                    getPokemonMoreInfoUseCase = pokemonMoreInfoUseCase
                )
            }
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
                ViewState.IDLE -> viewModel.getPokemons(paginationRange)
                else -> {}
            }
        }

        viewModel.pokemons.observe(this) {
            it.forEachIndexed { index, pokemon ->
                adapter.items.add(pokemon)
                adapter.notifyItemInserted(layoutManager.itemCount + index)
            }

            paginationRange.next()
            viewModel.getPokemons(paginationRange)
        }
    }

    interface PokemonViewHolderInterface {
        fun onPokemonClick(pokemon: Pokemon)
        fun createMoreInfoViewModel(): MoreInfoViewModel
    }
}