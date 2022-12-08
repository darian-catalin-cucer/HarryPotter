package cucerdariancatalin.harrypotter.di

import cucerdariancatalin.harrypotter.ui.HouseType
import cucerdariancatalin.harrypotter.ui.detail.DetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (type: HouseType) -> DetailViewModel(type, repository = get()) }
}