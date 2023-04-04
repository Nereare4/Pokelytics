package study.project.pokelytics.api.service

import POKE_API_COLOR_URL
import POKE_API_MOVES_URL
import POKE_API_POKEMONS_URL
import study.project.pokelytics.api.models.MoveResponse
import study.project.pokelytics.api.models.Pokemon
import study.project.pokelytics.api.models.pages.BasePage
import study.project.pokelytics.api.models.responses.ItemResponse
import study.project.pokelytics.repositories.ColorRepository
import study.project.pokelytics.repositories.MoveRepository
import study.project.pokelytics.repositories.PokemonRepository
import study.project.pokelytics.repositories.SpeciesRepository
import java.net.URL

object PokeApiRequestManager {

    private val pokemonManager: PokemonRepository by lazy { PokemonRepository() }
    private val moveManager: MoveRepository by lazy { MoveRepository() }
    private val speciesManager: SpeciesRepository by lazy { SpeciesRepository() }
    private val colorManager: ColorRepository by lazy { ColorRepository() }
    fun getAllResults(): ArrayList<ItemResponse> {
        val list = arrayListOf<ItemResponse>()
        var nextUrl = POKE_API_POKEMONS_URL
        var res: BasePage
        do {
            res = pokemonManager.getResponseFromURL(URL(nextUrl))
            res.let {
                list.addAll(it.results)
            }
            nextUrl = res.next ?: ""
        } while (res.next.isNullOrEmpty().not())
        return list
    }

    /*fun getAllPokemon(): ArrayList<Pokemon> {
        val list = arrayListOf<Pokemon>()
        var count = 1
        var res: Pokemon
        do {
            res = pokemonManager.getPokemonFromURL(URL("$POKE_API_POKEMONS_URL/$count"))
            list.add(res)
            count++
        } while (res.id != null)
        list.remove(list.last())
        return list
    }

    fun getPokemon(url: String): Pokemon {
        return pokemonManager.getPokemonFromURL(URL(url))
    }

    fun getPokemonFromName(name: String): Pokemon {
        return pokemonManager.getPokemonFromURL(URL("$POKE_API_POKEMONS_URL/$name"))
    }

    fun getPokemon(num: Int): Pokemon {
        return pokemonManager.getPokemonFromURL(URL("$POKE_API_POKEMONS_URL/$num"))
    }*/

    fun getAllMovesPages(): ArrayList<ItemResponse> {
        val list = arrayListOf<ItemResponse>()
        var nextUrl = POKE_API_MOVES_URL
        var res: BasePage
        do {
            res = moveManager.getResponseFromURL(URL(nextUrl))
            res.let {
                list.addAll(it.results)
            }
            nextUrl = res.next ?: ""
        } while (res.next.isNullOrEmpty().not())
        return list
    }
    fun getAllMoves(): ArrayList<MoveResponse> {
        val list = arrayListOf<MoveResponse>()
        var count = 1
        var res: MoveResponse
        do {
            val url = URL("$POKE_API_MOVES_URL/$count")
            res = moveManager.getMoveFromURL(url)
            list.add(res)
            count++
        } while (res.id != null)
        list.remove(list.last())
        return list
    }

    fun getMove(url: String): MoveResponse {
        return moveManager.getMoveFromURL(URL(url))
    }

    fun getMoveFromName(name: String): MoveResponse {
        return moveManager.getMoveFromURL(URL("$POKE_API_MOVES_URL/$name"))
    }

    fun getMove(num: Int): MoveResponse {
        return moveManager.getMoveFromURL(URL("$POKE_API_MOVES_URL/$num"))
    }

    fun getAllColors(): ArrayList<ItemResponse> {
        return colorManager.getAllColors(URL(POKE_API_COLOR_URL)).results
    }
}