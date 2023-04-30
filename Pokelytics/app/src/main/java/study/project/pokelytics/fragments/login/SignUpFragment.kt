package study.project.pokelytics.fragments.login

import androidx.activity.OnBackPressedCallback
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

    val callback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            findNavController().navigate(R.id.signUpFragmentToLoginSelectionFragment)
        }
    }


}