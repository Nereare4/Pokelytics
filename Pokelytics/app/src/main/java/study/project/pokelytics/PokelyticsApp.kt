package study.project.pokelytics

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import study.project.pokelytics.di.viewModelModule

class PokelyticsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokelyticsApp)
            modules(viewModelModule)
        }
    }
}