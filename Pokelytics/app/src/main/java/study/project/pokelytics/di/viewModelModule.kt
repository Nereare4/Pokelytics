package study.project.pokelytics.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import study.project.pokelytics.viewmodels.PokemonListViewModelFragment

@ExperimentalCoroutinesApi
@FlowPreview
val viewModelModule = module {
    viewModel { PokemonListViewModelFragment(get()) }
}