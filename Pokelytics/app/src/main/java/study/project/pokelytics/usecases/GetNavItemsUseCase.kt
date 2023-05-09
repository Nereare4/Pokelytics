package study.project.pokelytics.usecases

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import study.project.pokelytics.models.NavItem

class GetNavItemsUseCase(
    private val firebaseAuth: FirebaseAuth
) : FlowUseCase<List<NavItem>, Unit>() {

    override suspend fun execute(params: Unit): Flow<List<NavItem>> {
        return
    }

}
