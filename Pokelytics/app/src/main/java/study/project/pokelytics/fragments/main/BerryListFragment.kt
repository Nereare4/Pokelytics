package study.project.pokelytics.fragments.main

import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.adapters.BerryListAdapter
import study.project.pokelytics.api.model.PaginationRange
import study.project.pokelytics.databinding.FragmentPokemonListBinding
import study.project.pokelytics.fragments.FragmentBase
import study.project.pokelytics.viewmodels.BerryViewModel
import study.project.pokelytics.viewmodels.ViewState

class BerryListFragment : FragmentBase<FragmentPokemonListBinding>() {

    private val viewModel: BerryViewModel by viewModel()
    private lateinit var adapter: BerryListAdapter
    private val layoutManager: LinearLayoutManager = LinearLayoutManager(context)
    private val paginationRange = PaginationRange()

    override fun bindViewModel() {
        binding.apply {
            this.lifecycleOwner = this@BerryListFragment
        }
    }

    override fun initializeView() {
        adapter = BerryListAdapter()

        binding.apply {
            pokemonRecycler.layoutManager = layoutManager
            pokemonRecycler.adapter = adapter
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
                ViewState.IDLE -> viewModel.getBerryList(paginationRange)
                else -> {}
            }
        }

        viewModel.berryList.observe(this) {
            it.forEachIndexed { index, berry ->
                adapter.items.add(berry)
                adapter.notifyItemInserted(layoutManager.itemCount + index)
            }

            if(it.isNotEmpty() && it.lastOrNull()?.id != null) {
                if (paginationRange.stop) {
                    return@observe
                }
                paginationRange.next()
                viewModel.getBerryList(paginationRange)
            }
        }
    }
}