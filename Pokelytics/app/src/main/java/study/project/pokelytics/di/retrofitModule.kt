package study.project.pokelytics.di

import org.koin.dsl.module
import study.project.pokelytics.api.client.PokeApiClient

val retrofitModule = module {
    factory { PokeApiClient() }
}