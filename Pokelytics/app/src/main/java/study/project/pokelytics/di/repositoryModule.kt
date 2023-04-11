package study.project.pokelytics.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module
import study.project.pokelytics.repositories.PokemonRepository

@FlowPreview
@ExperimentalCoroutinesApi
val repositoryModule = module {
    factory { PokemonRepository() }
}