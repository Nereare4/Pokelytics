package study.project.pokelytics.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import study.project.pokelytics.NAVIGATE_TIMEOUT
import study.project.pokelytics.R
import study.project.pokelytics.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : ActivityBase<ActivitySplashBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        openApp()

        val fuego = findViewById<ImageView>(R.id.fuego)
        val pokeball = findViewById<ImageView>(R.id.pokeball)

        val animFuego = AnimationUtils.loadAnimation(this, R.anim.move_left_to_right)
        val animPokeball = AnimationUtils.loadAnimation(this, R.anim.rotate_pokeball)

        fuego.startAnimation(animFuego)
        pokeball.startAnimation(animPokeball)
    }

    private fun openApp() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                navigator.goToLogin()
            }, 3000
        )
    }

    override fun getResourceLayout(): Int = R.layout.activity_splash

    override fun initializeView() {}

    override fun bindViewModel() {}

    override fun subscribe() {}

}