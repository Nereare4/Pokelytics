package study.project.pokelytics.viewmodels

import study.project.pokelytics.firebase.FirebaseHelper
import study.project.pokelytics.models.User

class FavViewModel(
    private val firebaseHelper: FirebaseHelper
): ViewModalBase() {

    fun saveFavs(user: User) {
        firebaseHelper.saveFavs(user)
    }
}
