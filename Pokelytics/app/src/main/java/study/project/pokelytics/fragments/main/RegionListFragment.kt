package study.project.pokelytics.fragments.main

import com.google.android.flexbox.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.adapters.RegionListAdapter
import study.project.pokelytics.api.model.PaginationRange
import study.project.pokelytics.databinding.FragmentRegionsListBinding
import study.project.pokelytics.fragments.FragmentBase
import study.project.pokelytics.viewmodels.RegionViewModel
import study.project.pokelytics.viewmodels.ViewState

class RegionListFragment : FragmentBase<FragmentRegionsListBinding>()  {
    private val viewModel: RegionViewModel by viewModel()
    private lateinit var adapter: RegionListAdapter
    private lateinit var layoutManager: FlexboxLayoutManager
    private var paginationRange = PaginationRange()

    override fun bindViewModel() {
        binding.apply {
            this.lifecycleOwner = this@RegionListFragment
        }
    }

    override fun initializeView() {
        adapter = RegionListAdapter()
        layoutManager = FlexboxLayoutManager(binding.root.context).apply {
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
        }

        binding.apply {
            regionRecycler.layoutManager = layoutManager
            regionRecycler.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshState(ViewState.IDLE)
    }

    override fun getResourceLayout(): Int = R.layout.fragment_regions_list

    override fun subscribe() {
        viewModel.state.observe(this) {
            when (it) {
                ViewState.IDLE -> {
                    adapter.items.clear()
                    paginationRange = PaginationRange()
                    viewModel.getRegionList(paginationRange)
                }
                else -> {}
            }
        }

        viewModel.regionList.observe(this) {
            it.forEachIndexed { index, region ->
                adapter.items.add(region)
                adapter.notifyItemInserted(layoutManager.itemCount + index)
            }

            if(it.isNotEmpty() && it.lastOrNull()?.id != null) {
                if (paginationRange.stop) {
                    return@observe
                }
                paginationRange.next()
                viewModel.getRegionList(paginationRange)
            }
        }
    }
}