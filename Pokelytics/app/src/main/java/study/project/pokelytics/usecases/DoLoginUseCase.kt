package study.project.pokelytics.usecases

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import study.project.pokelytics.models.LoginCredentials


class DoLoginUseCase (
    private val fAuth: FirebaseAuth
) : FlowUseCase<Unit, LoginCredentials>() { //Unit, LoginCredentials(mail, pass)

    override suspend fun execute(params: LoginCredentials): Flow<Unit> {

        //AQUI HAGO MI LOGIN NORMAL
        val email = params.email
        val password = params.password

        fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!it.isSuccessful) {
                throw(Exception(""))
            }
        }
        return flowOf()
    }


}