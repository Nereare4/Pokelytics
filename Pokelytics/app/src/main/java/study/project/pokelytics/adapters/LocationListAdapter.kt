package study.project.pokelytics.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import study.project.pokelytics.api.model.Location
import study.project.pokelytics.databinding.LocationListItemBinding
import study.project.pokelytics.viewholders.LocationViewHolder

class LocationListAdapter : BaseRecyclerAdapter<Location, LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = LocationListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onViewAttachedToWindow(holder: LocationViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.onAttached()
    }
}