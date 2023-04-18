package study.project.pokelytics.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import study.project.pokelytics.NAVIGATE_TIMEOUT
import study.project.pokelytics.R
import study.project.pokelytics.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : ActivityBase<ActivitySplashBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                navigator.goToLogin()
            }, NAVIGATE_TIMEOUT
        )
    }

    override fun getResourceLayout(): Int = R.layout.activity_splash

    override fun initializeView() {}

    override fun bindViewModel() {}

    override fun subscribe() {}

}