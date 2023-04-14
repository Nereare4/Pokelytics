package study.project.pokelytics.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import study.project.pokelytics.R
import study.project.pokelytics.databinding.ActivityLoginBinding

class LoginActivity : ActivityBase<ActivityLoginBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun getResourceLayout(): Int = R.layout.activity_main

    override fun initializeView() {
        TODO("Not yet implemented")
    }

    override fun bindViewModel() {
        TODO("Not yet implemented")
    }

    override fun subscribe() {
        TODO("Not yet implemented")
    }
}