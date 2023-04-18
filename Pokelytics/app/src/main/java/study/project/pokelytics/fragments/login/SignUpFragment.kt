package study.project.pokelytics.fragments.login

import androidx.navigation.fragment.findNavController
import study.project.pokelytics.R
import study.project.pokelytics.databinding.FragmentSignUpBinding
import study.project.pokelytics.fragments.FragmentBase


class SignUpFragment : FragmentBase<FragmentSignUpBinding>() {
    override fun bindViewModel() {
        binding.apply {
            lifecycleOwner = this@SignUpFragment
        }
    }

    override fun initializeView() {
        binding.btnCancel.setOnClickListener{
            findNavController().navigate(R.id.signUpFragmentToLoginSelectionFragment)
        }
    }

    override fun getResourceLayout(): Int = R.layout.fragment_sign_up

    override fun subscribe() {}


}