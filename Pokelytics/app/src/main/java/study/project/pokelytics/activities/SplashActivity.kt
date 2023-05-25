package study.project.pokelytics.activities

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import study.project.pokelytics.R
import study.project.pokelytics.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : ActivityBase<ActivitySplashBinding>() {
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
                navigator.goToLogin()
                finish()
            }, 3000
        )
    }
    override fun bindViewModel() {}

    override fun subscribe() {

    }

}