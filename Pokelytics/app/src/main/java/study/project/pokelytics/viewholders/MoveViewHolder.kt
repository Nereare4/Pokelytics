package study.project.pokelytics.viewholders

import android.annotation.SuppressLint
import study.project.pokelytics.api.model.Move
import study.project.pokelytics.databinding.MoveListItemBinding

class MoveViewHolder(
    private val binding: MoveListItemBinding,
) : BaseViewHolder<Move>(binding.root) {


    override fun bind(move: Move) {
        drawMove(move)
    }

    @SuppressLint("SetTextI18n")
    private fun drawMove(move: Move) {
        binding.apply {
            name.text = move.name
            move.id.toString().let {
                when (it.length) {
                    1 -> id.text = "#00$it"
                    2 -> id.text = "#0$it"
                    else -> id.text = "#$it"
                }
            }
        }
    }
}