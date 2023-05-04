package study.project.pokelytics.usecases

import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import study.project.pokelytics.models.User
import study.project.pokelytics.services.PreferenceService

class SaveUserPreferencesUseCase (

    private val preferenceService: PreferenceService

) : FlowUseCase<Unit, User>() { //Unit, User(mail, pass)

    override suspend fun execute(params: User): Flow<Unit> {

        return flowOf()
    }
}


