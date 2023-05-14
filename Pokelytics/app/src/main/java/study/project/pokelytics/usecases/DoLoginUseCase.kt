package study.project.pokelytics.usecases

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import study.project.pokelytics.models.LoginCredentials
import study.project.pokelytics.models.User


class DoLoginUseCase (
    private val fAuth: FirebaseAuth
) : FlowUseCase<User, LoginCredentials>() { //Unit, LoginCredentials(mail, pass)

    override suspend fun execute(params: LoginCredentials): Flow<User> = flow {

        //AQUI HAGO MI LOGIN NORMAL
        val email = params.email
        val password = params.password

        fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!it.isSuccessful) {
                throw(Exception(""))
            }
        }
        //donde esta el emit tengo que recoger el usuario de bd el usuario entero
        //añado en Models>user los datos que recoja :)

        emit(User("añskdñ", "dñkxn"))
    }
}