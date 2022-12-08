package cucerdariancatalin.harrypotter.ui.main

import android.os.Bundle
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import cucerdariancatalin.harrypotter.R
import cucerdariancatalin.harrypotter.base.BaseActivity
import cucerdariancatalin.harrypotter.databinding.ActivityMainBinding
import cucerdariancatalin.harrypotter.ui.detail.DetailActivity.Companion.startActivityWithTransition

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            lifecycleOwner = this@MainActivity
            bindDiscreteScroll()
        }
    }

    private fun ActivityMainBinding.bindDiscreteScroll() {
        with(scrollViewMainList) {
            adapter = MainAdapter { view, type ->
                startActivityWithTransition(this@MainActivity, view, type)
            }
            setItemTransformer(
                ScaleTransformer.Builder()
                    .setMaxScale(1.25f)
                    .setMinScale(0.8f)
                    .build()
            )
        }
    }

}