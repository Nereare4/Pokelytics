package study.project.pokelytics.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.adapters.PokemonListAdapter
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.api.models.pages.PaginationRange
import study.project.pokelytics.databinding.FragmentPokemonListBinding
import study.project.pokelytics.usecases.GetPokemonMoreInfoUseCase
import study.project.pokelytics.viewmodels.MoreInfoViewModel
import study.project.pokelytics.viewmodels.PokemonListViewModel
import study.project.pokelytics.viewmodels.ViewState

class PokemonListFragment : FragmentBase<FragmentPokemonListBinding>() {

    private val viewModel: PokemonListViewModel by viewModel()
    private lateinit var adapter: PokemonListAdapter
    private val layoutManager: LinearLayoutManager = LinearLayoutManager(context)
    private val paginationRange = PaginationRange()
    private var loadable = false
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

        loadScrollListener()
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

    private fun loadScrollListener() {
        binding.pokemonRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                val totalItemCount = layoutManager.itemCount

                if (lastVisibleItemPosition > totalItemCount - 15 && loadable) {
                    loadable = false
                    paginationRange.next()
                    viewModel.getPokemons(paginationRange)
                }
            }
        })

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
            adapter.items.addAll(it)
            adapter.notifyDataSetChanged()
            loadable = true
        }
    }

    interface PokemonViewHolderInterface {
        fun onPokemonClick(pokemon: Pokemon)
        fun createMoreInfoViewModel(): MoreInfoViewModel
    }
}