package cucerdariancatalin.harrypotter.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import cucerdariancatalin.harrypotter.model.Character
import cucerdariancatalin.harrypotter.data.repository.Repository
import cucerdariancatalin.harrypotter.ui.HouseType

class DetailViewModel(house: HouseType, private val repository: Repository) : ViewModel() {

    val characterList : LiveData<List<Character>> = liveData {
        isLoading.value = true
        emit(repository.getCharacters(house.name))
        isLoading.value = false
    }

    val isLoading = MutableLiveData<Boolean>()

}