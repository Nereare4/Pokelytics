package study.project.pokelytics.usecases

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import study.project.pokelytics.models.LoginCredentials
import study.project.pokelytics.viewmodels.ViewState


class DoLoginUseCase (

) : FlowUseCase<Unit, LoginCredentials>() { //Unit, LoginCredentials(mail, pass)

    lateinit var fAuth: FirebaseAuth
    lateinit var email: String
    lateinit var password: String

    override suspend fun execute(params: LoginCredentials): Flow<Unit> {

        //AQUI HAGO MI LOGIN NORMAL
        fAuth = FirebaseAuth.getInstance()
        email = params.email
        password = params.password

        fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!it.isSuccessful) {
                throw(Exception(""))
            }
        }
        return flowOf()
    }


}