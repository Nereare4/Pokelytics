package study.project.pokelytics.models

import com.google.firebase.firestore.DocumentSnapshot
import study.project.pokelytics.api.model.Pokemon

class User (val email: String, val name: String, var favouriteList: String): java.io.Serializable{

    fun addFav(pokemon: Pokemon): Boolean {
        val list = favouriteList.split(",").toMutableList()
        if (list.size >= 6) {
            return false
        }
        list.add(pokemon.id.toString())
        favouriteList = list.joinToString(",")
        return true
    }

    companion object {
        fun fromDataBase(it: DocumentSnapshot): User {
            return User("", "", "")
        }
        fun getDefaultUser(): User {
            return User("", "", "")
        }

        private var instance = getDefaultUser()
        fun getInstance(): User {
            return instance
        }
        fun setInstance(user: User) {
            instance = user
        }
    }

}