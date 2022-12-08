package cucerdariancatalin.harrypotter.data.remote

import cucerdariancatalin.harrypotter.data.service.HarryPotterService

class RemoteDataSourceImpl(private val service: HarryPotterService) : RemoteDataSource {

    override suspend fun getCharacters(type: String) = service.getCharacters(type)

}