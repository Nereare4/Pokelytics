package study.project.pokelytics.models

import com.google.firebase.firestore.DocumentSnapshot

class User (val email: String, val password: String){
    companion object {
        fun fromDataBase(it: DocumentSnapshot): User {
            return User("", "")
        }
    }

}