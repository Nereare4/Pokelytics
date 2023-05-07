package study.project.pokelytics.viewholders

import study.project.pokelytics.databinding.NavItemBinding
import study.project.pokelytics.models.NavItem

class NavItemViewHolder(
    val binding: NavItemBinding
) : BaseViewHolder<NavItem>(binding.root) {

    override fun bind(item: NavItem) {
        binding.apply {
            title.text = item.title
            icon.setImageResource(item.iconResId)
        }
    }

}
