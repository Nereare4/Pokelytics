package study.project.pokelytics.usecases

import kotlinx.coroutines.flow.Flow
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.api.models.pages.PaginationRange
import study.project.pokelytics.repositories.PokemonRepository

class GetPokemonUseCase(
    private val pokemonRepository: PokemonRepository
) : FlowUseCase<List<Pokemon>, PaginationRange>() {

    override suspend fun execute(params: PaginationRange): Flow<List<Pokemon>> {
        return pokemonRepository.getPokemonFromURL(params)
    }
}