package study.project.pokelytics.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import study.project.pokelytics.event.postEvent
import study.project.pokelytics.models.NavItem
import study.project.pokelytics.usecases.GetNavItemsUseCase

class NavigationViewModel(
    val getNavItemsUseCase: GetNavItemsUseCase
): ViewModalBase() {

    private val mutableNavItems = MutableLiveData<List<NavItem>>()
    val navItems: LiveData<List<NavItem>>
        get() = mutableNavItems

    fun getNavItems() {
        mutableState.postValue(ViewState.LOADING)
        viewModelScope.launch {
            getNavItemsUseCase(
                {
                    mutableState.postValue(ViewState.SUCCESS)
                    mutableNavItems.postEvent(it)
                }, {
                    mutableState.postValue(ViewState.ERROR)
                }
            )
        }
    }
}
