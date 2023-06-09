package study.project.pokelytics.activities

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.databinding.ActivitySplashBinding
import study.project.pokelytics.models.User
import study.project.pokelytics.viewmodels.SplashViewModel
import study.project.pokelytics.viewmodels.ViewState

@SuppressLint("CustomSplashScreen")
class SplashActivity : ActivityBase<ActivitySplashBinding>() {
    private val splashViewModel: SplashViewModel  by viewModel()
    override fun getResourceLayout(): Int = R.layout.activity_splash
    override fun initializeView() {
        openDelayedApp()
        binding.apply {
            fuego.startAnimation(
                AnimationUtils.loadAnimation(this@SplashActivity, R.anim.move_left_to_right)
            )
            pokeball.startAnimation(
                AnimationUtils.loadAnimation(this@SplashActivity, R.anim.rotate_pokeball)
            )
        }
    }
    private fun openDelayedApp() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                splashViewModel.openDelayedApp()
            }, 3000
        )
    }
    override fun bindViewModel() {}

    override fun subscribe() {
        splashViewModel.state.observe(this){
            when(it){
                ViewState.SUCCESS -> {
                    navigator.goToMain(User.getDefaultUser())//COGER USUARIO BD
                    finish()
                }
                ViewState.ERROR ->{
                    navigator.goToLogin()
                    finish()
                }
                else -> {}
            }
        }
    }

}