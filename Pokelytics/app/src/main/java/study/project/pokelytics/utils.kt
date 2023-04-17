package study.project.pokelytics

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.setImageToUrl(url: String, placeholder: Int = R.drawable.ic_image_placeholder) {
    Picasso.get()
        .load(url)
        .placeholder(placeholder)
        .into(this)
}