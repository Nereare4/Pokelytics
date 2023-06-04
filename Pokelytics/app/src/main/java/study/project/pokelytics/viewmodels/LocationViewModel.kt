package study.project.pokelytics.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import study.project.pokelytics.api.model.Location
import study.project.pokelytics.api.model.PaginationRange
import study.project.pokelytics.usecases.GetLocationUseCase

class LocationViewModel(
    val getLocationUseCase: GetLocationUseCase
) : ViewModalBase() {

    private val mutableLocationList = MutableLiveData<List<Location>>()
    val locationList: LiveData<List<Location>>
        get() = mutableLocationList

    fun getLocationList(paginationRange: PaginationRange) {
        mutableState.postValue(ViewState.LOADING)
        viewModelScope.launch {
            getLocationUseCase(
                paginationRange,
                { locationList ->
                    mutableState.postValue(ViewState.SUCCESS)
                    mutableLocationList.postValue(locationList)
                }, {
                    mutableState.postValue(ViewState.ERROR)
                }
            )
        }
    }
}