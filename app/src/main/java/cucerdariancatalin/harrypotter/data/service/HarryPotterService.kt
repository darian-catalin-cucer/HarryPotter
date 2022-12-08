package cucerdariancatalin.harrypotter.data.service

import cucerdariancatalin.harrypotter.model.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface HarryPotterService {

    @GET("api/characters/house/{house}")
    suspend fun getCharacters(@Path("house") type: String): List<Character>

}