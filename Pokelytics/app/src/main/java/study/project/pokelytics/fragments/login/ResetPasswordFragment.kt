package study.project.pokelytics.fragments.login

import androidx.navigation.fragment.findNavController
import study.project.pokelytics.R
import study.project.pokelytics.databinding.FragmentResetPasswordBinding
import study.project.pokelytics.fragments.FragmentBase

class ResetPasswordFragment : FragmentBase<FragmentResetPasswordBinding>() {

    override fun getResourceLayout(): Int = R.layout.fragment_reset_password

    override fun initializeView() {
        binding.apply {
            btnReset.setOnClickListener{
                findNavController().navigate(R.id.resetPasswordFragmentToLogInFragment)
            }
            btnCancel.setOnClickListener{
                findNavController().navigate(R.id.resetPasswordFragmentToLogInFragment)
            }
        }
    }

    override fun bindViewModel() {
        binding.apply {
            lifecycleOwner = this@ResetPasswordFragment
        }
    }

    override fun subscribe() {
    }
}