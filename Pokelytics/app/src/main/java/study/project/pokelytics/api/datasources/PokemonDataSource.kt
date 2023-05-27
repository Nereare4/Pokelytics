package study.project.pokelytics.api.datasources

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import study.project.pokelytics.api.client.PokeApiClient
import study.project.pokelytics.api.model.PaginationRange
import study.project.pokelytics.api.model.Pokemon

class PokemonDataSource(
    val remote: PokeApiClient
) {

    fun getPokemonFromPage(paginationRange: PaginationRange): Flow<List<Pokemon>> =
        remote.getPokemonList(paginationRange.from, paginationRange.count)

    fun getPokemonExtraInfo(params: Pokemon): Flow<Pokemon> = flow {
        /*val specie = params.species?.url.let { it1 -> remote.getSpecieFromUrl(it1 ?: "").execute() }
        val newPokemon = params.copy(extraInfo = PokemonExtraInfo(species = specie.body()))
        emit(newPokemon)*/
    }
}