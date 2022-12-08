package cucerdariancatalin.harrypotter.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import cucerdariancatalin.harrypotter.R
import cucerdariancatalin.harrypotter.databinding.DialogDetailBinding
import cucerdariancatalin.harrypotter.databinding.ItemCharacterBinding
import cucerdariancatalin.harrypotter.model.Character

class DetailAdapter : ListAdapter<Character, DetailAdapter.DetailViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<ItemCharacterBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_character,
            parent,
            false
        ).run {
            constraintLayoutItemArea.layoutParams.height = (parent.width / 3) * 2
            DetailViewHolder(this)
        }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class DetailViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                MaterialDialog(binding.root.context).show {
                    customView(
                        view = DataBindingUtil.inflate<DialogDetailBinding>(
                            LayoutInflater.from(binding.root.context),
                            R.layout.dialog_detail,
                            null,
                            false
                        ).apply {
                            character = binding.character
                            imageViewDialogDetailPhoto.clipToOutline = true
                        }.root
                    )
                    cornerRadius(binding.root.context.resources.getDimension(R.dimen.dp_8))
                }
            }
        }

        fun bind(item: Character) {
            with(binding) {
                character = item
                executePendingBindings()
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }
        }
    }

}
