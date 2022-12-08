package cucerdariancatalin.harrypotter.di

import cucerdariancatalin.harrypotter.data.repository.Repository
import cucerdariancatalin.harrypotter.data.repository.RepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<Repository> { RepositoryImpl(remoteDataSource = get()) }
}