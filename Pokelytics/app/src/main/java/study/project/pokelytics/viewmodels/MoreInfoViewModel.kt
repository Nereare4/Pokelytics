package study.project.pokelytics.viewmodels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import study.project.pokelytics.api.model.Pokemon
import study.project.pokelytics.event.LiveEvent
import study.project.pokelytics.event.MutableLiveEvent
import study.project.pokelytics.event.postEvent
import study.project.pokelytics.usecases.GetPokemonMoreInfoUseCase

class MoreInfoViewModel(
    val getPokemonMoreInfoUseCase: GetPokemonMoreInfoUseCase
): ViewModalBase() {

    private val mutablePokemon = MutableLiveEvent<Pokemon>()
    val pokemon: LiveEvent<Pokemon>
        get() = mutablePokemon

    fun getPokemons(item: Pokemon) {
        mutableState.postValue(ViewState.LOADING)
        viewModelScope.launch {
            getPokemonMoreInfoUseCase(
                item,
                {
                    mutableState.postValue(ViewState.SUCCESS)
                    mutablePokemon.postEvent(it)
                }, {
                    mutableState.postValue(ViewState.ERROR)
                }
            )
        }
    }
}
