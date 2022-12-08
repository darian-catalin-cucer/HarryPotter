package cucerdariancatalin.harrypotter.di

import cucerdariancatalin.harrypotter.data.remote.RemoteDataSource
import cucerdariancatalin.harrypotter.data.remote.RemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(service = get()) }
}