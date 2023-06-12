package study.project.pokelytics.fragments.main

import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.activities.MainActivity
import study.project.pokelytics.adapters.LocationListAdapter
import study.project.pokelytics.databinding.FragmentLocationsListBinding
import study.project.pokelytics.fragments.FragmentBase
import study.project.pokelytics.viewmodels.LocationViewModel
import study.project.pokelytics.viewmodels.ViewState

class LocationsListFragment : FragmentBase<FragmentLocationsListBinding>()  {

    private val viewModel: LocationViewModel by viewModel()
    private lateinit var adapter: LocationListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun bindViewModel() {
        binding.apply {
            this.lifecycleOwner = this@LocationsListFragment
        }
    }

    override fun initializeView() {
        adapter = LocationListAdapter()
        layoutManager = LinearLayoutManager(context)
        val args: LocationsListFragmentArgs by navArgs()
        viewModel.getLocationList(args.locationList)
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
        viewModel.state.observe(this){
            (activity as MainActivity).showLoading(it == ViewState.LOADING && adapter.items.isNotEmpty())
        }
        viewModel.locationList.observe(this) {
            it.forEachIndexed { index, location ->
                adapter.items.add(location)
                adapter.notifyItemInserted(layoutManager.itemCount + index)
            }
        }
    }
}