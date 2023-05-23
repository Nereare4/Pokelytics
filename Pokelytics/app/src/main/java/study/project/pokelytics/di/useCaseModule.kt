package study.project.pokelytics.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module
import study.project.pokelytics.usecases.GetPokemonMoreInfoUseCase
import study.project.pokelytics.usecases.GetPokemonUseCase
import study.project.pokelytics.usecases.*

@FlowPreview
@ExperimentalCoroutinesApi
val useCaseModule = module {
    factory { GetPokemonUseCase(get()) }
    factory { GetPokemonMoreInfoUseCase(get()) }
    factory { SaveUserPreferencesUseCase(get()) }
}