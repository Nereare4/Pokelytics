package study.project.pokelytics.usecases

import kotlinx.coroutines.flow.Flow
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.repositories.PokemonRepository

class GetPokemonMoreInfoUseCase(
    private val pokemonRepository: PokemonRepository
) : FlowUseCase<Pokemon, Pokemon>() {

    override suspend fun execute(params: Pokemon): Flow<Pokemon> {
        return pokemonRepository.getPokemonExtraInfo(params)
    }

}
