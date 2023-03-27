package study.project.pokelytics.activities

import study.project.pokelytics.R
import study.project.pokelytics.databinding.ActivityMainBinding
import study.project.pokelytics.viewmodels.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ActivityBase<ActivityMainBinding>() {

    val viewModel: MainActivityViewModel by viewModel()

    override fun getResourceLayout(): Int = R.layout.activity_main
    override fun initializeView() {

    }
    override fun bindViewModel() {

    }
    override fun subscribe() {

    }
}