package study.project.pokelytics.fragments.login

import androidx.navigation.fragment.findNavController
import study.project.pokelytics.R
import study.project.pokelytics.databinding.FragmentLoginSelectionBinding
import study.project.pokelytics.fragments.FragmentBase

class LoginSelectionFragment : FragmentBase<FragmentLoginSelectionBinding>() {

    override fun getResourceLayout(): Int = R.layout.fragment_login_selection

    override fun initializeView() {
        binding.apply {
            btnSignUp.setOnClickListener{
                findNavController().navigate(R.id.loginSelectionFragmentToSignUpFragment)
            }
            btnLogin.setOnClickListener{
                findNavController().navigate(R.id.loginSelectionFragmentToLogInFragment)
            }
        }
    }

    override fun bindViewModel() {
        binding.apply {
            lifecycleOwner = this@LoginSelectionFragment
        }
    }

    override fun subscribe() {
    }

}