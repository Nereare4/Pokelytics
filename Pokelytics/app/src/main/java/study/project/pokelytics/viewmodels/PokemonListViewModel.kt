package study.project.pokelytics.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import study.project.pokelytics.api.model.PaginationRange
import study.project.pokelytics.api.model.Pokemon
import study.project.pokelytics.usecases.GetPokemonUseCase

class PokemonListViewModel(
    val getPokemonUseCase: GetPokemonUseCase
) : ViewModalBase() {

    private val mutablePokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>>
        get() = mutablePokemons

    fun getPokemonList(paginationRange: PaginationRange) {
        mutableState.postValue(ViewState.LOADING)
        viewModelScope.launch {
            getPokemonUseCase(
                paginationRange,
                { pokemonList ->
                    mutableState.postValue(ViewState.SUCCESS)
                    mutablePokemons.postValue(pokemonList)
                }, {
                    mutableState.postValue(ViewState.ERROR)
                }
            )
        }
    }
}