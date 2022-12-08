package cucerdariancatalin.harrypotter.data.remote

import cucerdariancatalin.harrypotter.model.Character

interface RemoteDataSource {

    suspend fun getCharacters(type: String) : List<Character>

}