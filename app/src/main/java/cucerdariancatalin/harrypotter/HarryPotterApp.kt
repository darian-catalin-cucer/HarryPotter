package cucerdariancatalin.harrypotter

import android.app.Application
import cucerdariancatalin.harrypotter.di.dataSourceModule
import cucerdariancatalin.harrypotter.di.networkModule
import cucerdariancatalin.harrypotter.di.repositoryModule
import cucerdariancatalin.harrypotter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HarryPotterApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HarryPotterApp)
            modules(dataSourceModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(networkModule)
        }
    }

}