package study.project.pokelytics.fragments.login

import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.activities.ActivityBase
import study.project.pokelytics.databinding.FragmentSignUpBinding
import study.project.pokelytics.fragments.FragmentBase
import study.project.pokelytics.models.LoginCredentials
import study.project.pokelytics.viewmodels.SignUpViewModel
import study.project.pokelytics.viewmodels.ViewState


class SignUpFragment : FragmentBase<FragmentSignUpBinding>() {

    override fun getResourceLayout(): Int = R.layout.fragment_sign_up
    private val signUpViewModel: SignUpViewModel by viewModel()



    override fun initializeView() {
        binding.apply {
            btnSignUp.setOnClickListener {
                val expRegular = Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{6,15}\$")

                if (email.text.isEmpty() && password.text.isEmpty() && repassword.text.isEmpty()) {
                    showError(etemail, resources.getString(R.string.emailRequired))
                    showError(etpassword, resources.getString(R.string.passRequired))
                    showError(etrepassword, resources.getString(R.string.repassRequired))
                } else if (!email.text.contains("@")) {
                    showError(etemail, resources.getString(R.string.emailValid))  //This field can´t be empty
                } else if (!expRegular.matches(password.text.toString())) {
                    showError(etpassword, resources.getString(R.string.passNeeds))
                } else if (!password.text.toString().equals(repassword.text.toString())) {
                    showError(etpassword, resources.getString(R.string.passSame))
                } else {
                    val credentials = LoginCredentials(email.text.toString(), password.text.toString())
                    signUpViewModel.signUp(credentials)
                }
                binding.btnCancel.setOnClickListener {
                    findNavController().navigate(R.id.signUpFragmentToLoginSelectionFragment)
                }
            }
        }
    }
    override fun bindViewModel() {
        binding.apply {
            lifecycleOwner = this@SignUpFragment
        }
    }

    override fun subscribe() {
        signUpViewModel.state.observe(viewLifecycleOwner){
            when(it){
                ViewState.SUCCESS -> {
                    (activity as ActivityBase<*>).navigator.goToMain()
                }
                ViewState.ERROR ->{
                    showErrorSignUp()
                }
                else -> {}
            }
        }
    }

    private fun showError(textInputLayout: TextInputLayout, error: String) {
        textInputLayout.error = error
    }

    private fun showErrorSignUp(){
        Toast.makeText(requireContext(), resources.getString(R.string.emailExists), Toast.LENGTH_SHORT).show()
    }

    val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            findNavController().navigate(R.id.signUpFragmentToLoginSelectionFragment)
        }
    }


}