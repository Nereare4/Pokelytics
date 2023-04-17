package study.project.pokelytics

import android.app.Application
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import study.project.pokelytics.di.appModule
import study.project.pokelytics.di.repositoryModule
import study.project.pokelytics.di.useCaseModule
import study.project.pokelytics.di.viewModelModule

class PokelyticsApp : Application() {
    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokelyticsApp)
            modules(
                listOf(
                    viewModelModule,
                    useCaseModule,
                    repositoryModule,
                    appModule
                )
            )
        }
    }
}