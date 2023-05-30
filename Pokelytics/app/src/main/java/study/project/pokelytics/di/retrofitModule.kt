package study.project.pokelytics.di

import org.koin.dsl.module
import study.project.pokelytics.api.client.PokeApiClient
import study.project.pokelytics.api.datasources.BerryDataSource
import study.project.pokelytics.api.datasources.MoveDataSource
import study.project.pokelytics.api.datasources.PokemonDataSource

val retrofitModule = module {
    factory { PokeApiClient() }
    factory { PokemonDataSource(get()) }
    factory { BerryDataSource(get()) }
    factory { MoveDataSource(get()) }
}