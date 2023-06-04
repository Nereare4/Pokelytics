package study.project.pokelytics.viewholders

import android.annotation.SuppressLint
import android.widget.ImageView
import study.project.pokelytics.R
import study.project.pokelytics.api.model.Location
import study.project.pokelytics.databinding.LocationListItemBinding

class LocationViewHolder(
    private val binding: LocationListItemBinding,
) : BaseViewHolder<Location>(binding.root) {


    override fun bind(item: Location) {
        drawLocation(item)
    }

    @SuppressLint("SetTextI18n")
    private fun drawLocation(location: Location) {
        binding.apply {
            name.text = location.name
            location.id.toString().let {
                when (it.length) {
                    1 -> id.text = "#00$it"
                    2 -> id.text = "#0$it"
                    else -> id.text = "#$it"
                }
            }
            location.region?.let { setImage(image, it.name) }
        }
    }

    private fun setImage(image: ImageView, name: String) {
        image.setImageResource(
            when (name) {
                "physical" -> R.mipmap.ic_physical
                "special" -> R.mipmap.ic_special
                else -> R.mipmap.ic_status
            }
        )
    }


}