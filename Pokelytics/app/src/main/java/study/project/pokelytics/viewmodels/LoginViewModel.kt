package study.project.pokelytics.viewmodels

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import study.project.pokelytics.models.LoginCredentials
import study.project.pokelytics.models.User
import study.project.pokelytics.usecases.DoLoginUseCase
import study.project.pokelytics.usecases.SaveUserPreferencesUseCase

class LoginViewModel(
    val doLoginUseCase: DoLoginUseCase,
    val saveUserPreferencesUseCase: SaveUserPreferencesUseCase
) : ViewModalBase() {

    fun login(loginCredentials: LoginCredentials) {
        mutableState.postValue(ViewState.LOADING)
        viewModelScope.launch {
            doLoginUseCase(
                loginCredentials,
                {
                    mutableState.postValue(ViewState.SUCCESS)
                    saveUserPreferences(it)
                }, {
                    mutableState.postValue(ViewState.ERROR)
                }
            )

        }
    }
    private fun saveUserPreferences(user: User){
        viewModelScope.launch {
            saveUserPreferencesUseCase(user)
        }
    }

}