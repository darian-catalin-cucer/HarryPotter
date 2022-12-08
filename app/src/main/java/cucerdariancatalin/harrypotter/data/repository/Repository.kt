package cucerdariancatalin.harrypotter.data.repository

import cucerdariancatalin.harrypotter.model.Character

interface Repository {

    suspend fun getCharacters(type: String) : List<Character>

}