package study.project.pokelytics.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<in T>(containerView: View): RecyclerView.ViewHolder(containerView) {

    abstract fun bind(item: T)

}