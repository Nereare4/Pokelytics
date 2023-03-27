package study.project.pokelytics.usecases

import kotlinx.coroutines.flow.Flow
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.repositories.PokemonRepository

class GetPokemonUseCase(
    private val pokemonRepository: PokemonRepository
) : FlowUseCase<List<Pokemon>, Int>() {

    override suspend fun execute(params: Int): Flow<List<Pokemon>> {
        return pokemonRepository.getPokemonFromURL(params)
    }
}