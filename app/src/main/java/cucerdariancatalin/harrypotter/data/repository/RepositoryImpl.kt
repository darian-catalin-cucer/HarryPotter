package cucerdariancatalin.harrypotter.data.repository

import cucerdariancatalin.harrypotter.data.remote.RemoteDataSource

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {

    override suspend fun getCharacters(type: String) =
        remoteDataSource.getCharacters(type)

}