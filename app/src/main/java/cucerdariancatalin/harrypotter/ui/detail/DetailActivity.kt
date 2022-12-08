package cucerdariancatalin.harrypotter.ui.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import cucerdariancatalin.harrypotter.R
import cucerdariancatalin.harrypotter.base.BaseActivity
import cucerdariancatalin.harrypotter.databinding.ActivityDetailBinding
import cucerdariancatalin.harrypotter.model.Character
import cucerdariancatalin.harrypotter.ui.HouseType
import cucerdariancatalin.harrypotter.ui.SpaceItemDecoration
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailActivity : BaseActivity() {

    private val binding by binding<ActivityDetailBinding>(R.layout.activity_detail)

    private val houseType by lazy { intent.getSerializableExtra(KEY_HOUSE) as HouseType }
    private val viewModel: DetailViewModel by viewModel { parametersOf(houseType) }
    private val detailAdapter by lazy {  DetailAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            lifecycleOwner = this@DetailActivity
            house = houseType
            vm = viewModel

            bindList(viewModel.characterList)
            bindImage(houseType.logo)
        }
    }

    private fun ActivityDetailBinding.bindList(
        characterList: LiveData<List<Character>>
    ) {
        with(recyclerViewDetail) {
            this.adapter = detailAdapter
            setBackgroundColor(
                ContextCompat.getColor(context, this@DetailActivity.houseType.color)
            )
            addItemDecoration(
                SpaceItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.dp_2), 3
                )
            )
        }
        characterList.observe(this@DetailActivity) {
            detailAdapter.submitList(it)
        }
    }

    private fun ActivityDetailBinding.bindImage(
        @DrawableRes
        imageResId: Int
    ) {
        imageViewDetail.setImageResource(imageResId)
    }

    companion object {
        private const val KEY_HOUSE = "house"

        fun startActivityWithTransition(
            activity: Activity,
            imageView: ImageView,
            type: HouseType
        ) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(KEY_HOUSE, type)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity, imageView, imageView.transitionName
            )
            activity.startActivity(intent, options.toBundle())
        }
    }

}