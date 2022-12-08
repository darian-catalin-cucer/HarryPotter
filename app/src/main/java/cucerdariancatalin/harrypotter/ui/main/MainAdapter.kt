package cucerdariancatalin.harrypotter.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cucerdariancatalin.harrypotter.R
import cucerdariancatalin.harrypotter.databinding.ItemHouseBinding
import cucerdariancatalin.harrypotter.ui.HouseType

class MainAdapter(
    val onItemClick: (ImageView, HouseType) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val items: Array<HouseType> = HouseType.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<ItemHouseBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_house,
            parent,
            false
        ).let { MainViewHolder(it) }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(items[position])

    inner class MainViewHolder(private val binding: ItemHouseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClick(
                    binding.imageViewItemHouseLogo,
                    items[bindingAdapterPosition]
                )
            }
        }

        fun bind(item: HouseType) {
            with(binding) {
                house = item
                imageViewItemHouseLogo.setImageResource(item.logo)
                executePendingBindings()
            }
        }
    }
}