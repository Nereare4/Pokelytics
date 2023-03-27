package study.project.pokelytics.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.usecases.GetPokemonUseCase

class PokemonListViewModelFragment(
    val getPokemonUseCase: GetPokemonUseCase
) : ViewModalBase() {

    private val mutablePokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>>
        get() = mutablePokemons

    fun getPokemons(paginationRange: Int) {
        mutableState.postValue(ViewState.LOADING)
        viewModelScope.launch {
            getPokemonUseCase(
                paginationRange,
                {
                    mutableState.postValue(ViewState.SUCCESS)
                    mutablePokemons.postValue(it)
                }, {
                    mutableState.postValue(ViewState.ERROR)
                }
            )
        }
    }
}