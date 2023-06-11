package study.project.pokelytics.models

import com.google.firebase.firestore.DocumentSnapshot

class User (val email: String, val name: String, val favouriteList: String): java.io.Serializable{
    companion object {
        fun fromDataBase(it: DocumentSnapshot): User {
            return User("", "", "")
        }
        fun getDefaultUser(): User {
            return User("", "", "")
        }
    }

}