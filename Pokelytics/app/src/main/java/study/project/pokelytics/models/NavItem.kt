package study.project.pokelytics.models

import com.google.gson.annotations.SerializedName
import study.project.pokelytics.R
import java.util.Locale

data class NavItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("icon")
    val icon: String,
    var iconResId: Int = 0
    ) {
    init {
        if (iconResId == 0) {
            mapId()
        }
    }

    fun mapId() {
        this.iconResId = when(icon.lowercase(Locale.ROOT)) {
            "home" -> R.drawable.ic_home
            "pokedex" -> R.drawable.ic_pokeball
            "berries" -> R.drawable.ic_berries
            "moves" -> R.drawable.ic_sword
            "items" -> R.drawable.ic_items
            "locations" -> R.drawable.ic_location
            "settings" -> R.drawable.ic_settings
            "logout" -> R.drawable.ic_exit
            else -> R.drawable.ic_pokeball
        }
    }
}