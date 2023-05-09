package study.project.pokelytics.viewmodels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import study.project.pokelytics.models.LoginCredentials
import study.project.pokelytics.usecases.DoLoginUseCase

class LoginViewModel(
    val doLoginUseCase: DoLoginUseCase
) : ViewModalBase() {

    fun login(loginCredentials: LoginCredentials) {
        mutableState.postValue(ViewState.LOADING)
        viewModelScope.launch {
            doLoginUseCase(
                loginCredentials,
                {
                    mutableState.postValue(ViewState.SUCCESS)
                }, {
                    mutableState.postValue(ViewState.ERROR)
                }
            )
        }
    }
}