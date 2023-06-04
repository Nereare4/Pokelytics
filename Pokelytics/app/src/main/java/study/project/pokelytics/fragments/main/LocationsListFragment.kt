package study.project.pokelytics.fragments.main

import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.adapters.LocationListAdapter
import study.project.pokelytics.api.model.PaginationRange
import study.project.pokelytics.databinding.FragmentLocationsListBinding
import study.project.pokelytics.fragments.FragmentBase
import study.project.pokelytics.viewmodels.LocationViewModel
import study.project.pokelytics.viewmodels.ViewState

class LocationsListFragment : FragmentBase<FragmentLocationsListBinding>()  {
    private val viewModel: LocationViewModel by viewModel()
    private lateinit var adapter: LocationListAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private var paginationRange = PaginationRange()

    override fun bindViewModel() {
        binding.apply {
            this.lifecycleOwner = this@LocationsListFragment
        }
    }

    override fun initializeView() {
        adapter = LocationListAdapter()
        layoutManager = LinearLayoutManager(context)

        binding.apply {
            pokemonRecycler.layoutManager = layoutManager
            pokemonRecycler.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshState(ViewState.IDLE)
    }

    override fun getResourceLayout(): Int = R.layout.fragment_locations_list

    override fun subscribe() {
        viewModel.state.observe(this) {
            when (it) {
                ViewState.IDLE -> {
                    adapter.items.clear()
                    paginationRange = PaginationRange()
                    viewModel.getLocationList(paginationRange)
                }
                else -> {}
            }
        }

        viewModel.locationList.observe(this) {
            it.forEachIndexed { index, location ->
                adapter.items.add(location)
                adapter.notifyItemInserted(layoutManager.itemCount + index)
            }

            if(it.isNotEmpty() && it.lastOrNull()?.id != null) {
                if (paginationRange.stop) {
                    return@observe
                }
                paginationRange.next()
                viewModel.getLocationList(paginationRange)
            }
        }
    }
}