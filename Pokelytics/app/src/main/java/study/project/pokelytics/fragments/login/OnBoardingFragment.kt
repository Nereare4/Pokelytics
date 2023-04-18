package study.project.pokelytics.fragments.login

import androidx.navigation.fragment.findNavController
import study.project.pokelytics.R
import study.project.pokelytics.activities.ActivityBase
import study.project.pokelytics.databinding.FragmentOnBoardingBinding
import study.project.pokelytics.fragments.FragmentBase

class OnBoardingFragment : FragmentBase<FragmentOnBoardingBinding>() {

    override fun getResourceLayout(): Int = R.layout.fragment_on_boarding

    override fun initializeView() {
        binding.apply {
            btnStart.setOnClickListener{
                (activity as ActivityBase<*>).navigator.goToMain()
            }
            btnLogin.setOnClickListener{
                findNavController().navigate(R.id.onBoardingFragmentToLoginSelectionFragment)
            }
        }
    }

    override fun bindViewModel() {
        binding.apply {
            lifecycleOwner = this@OnBoardingFragment
        }
    }

    override fun subscribe() {
    }

}