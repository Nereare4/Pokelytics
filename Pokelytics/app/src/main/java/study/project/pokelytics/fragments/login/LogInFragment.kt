package study.project.pokelytics.fragments.login

import androidx.navigation.fragment.findNavController
import study.project.pokelytics.R
import study.project.pokelytics.databinding.FragmentLogInBinding
import study.project.pokelytics.fragments.FragmentBase

class LogInFragment : FragmentBase<FragmentLogInBinding>() {

    override fun getResourceLayout(): Int = R.layout.fragment_log_in

    override fun initializeView() {
        binding.apply {
            btnCancel.setOnClickListener{
                findNavController().navigate(R.id.logInFragmentToLoginSelectionFragment)
            }
            resetPass.setOnClickListener{
                findNavController().navigate(R.id.logInFragmentToResetPasswordFragment)
            }
        }
    }

    override fun bindViewModel() {
        binding.apply {
            lifecycleOwner = this@LogInFragment
        }
    }

    override fun subscribe() {
    }
}