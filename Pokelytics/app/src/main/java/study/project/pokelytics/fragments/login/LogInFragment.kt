package study.project.pokelytics.fragments.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.databinding.FragmentLogInBinding
import study.project.pokelytics.fragments.FragmentBase
import study.project.pokelytics.models.LoginCredentials
import study.project.pokelytics.usecases.FlowUseCase
import study.project.pokelytics.viewmodels.LoginViewModel
import study.project.pokelytics.viewmodels.ViewState

class LogInFragment : FragmentBase<FragmentLogInBinding>() {

    override fun getResourceLayout(): Int = R.layout.fragment_log_in

    private val loginViewModel: LoginViewModel by viewModel()
    lateinit var emailTIL: TextInputLayout
    lateinit var passwordTIL: TextInputLayout

    override fun initializeView() {
        binding.apply {
            btnLogin.setOnClickListener {
                if (email.text.isEmpty() && password.text.isEmpty()){
                    showError(emailTIL, resources.getString(R.string.emailRequired))
                    showError(passwordTIL, resources.getString(R.string.passRequired))
                }else if(!email.text.contains("@")) {
                    showError(emailTIL, resources.getString(R.string.emailValid))
                }else{
                    val credentials = LoginCredentials(email.text.toString(), password.text.toString())
                    loginViewModel.login(credentials)
                }
            }
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
        loginViewModel.state.observe(viewLifecycleOwner){
            when(it){
                ViewState.SUCCESS -> {
                    funciona()
                }
                ViewState.ERROR ->{
                    showErrorLogin()
                }
                else -> {}
            }
        }
    }

    private fun showError(textInputLayout: TextInputLayout, error: String){
        textInputLayout.error = error
    }
    private fun showErrorLogin(){
        Toast.makeText(requireContext(), resources.getString(R.string.emailOrPassWrong), Toast.LENGTH_SHORT).show()
    }
    private fun funciona(){
        Toast.makeText(requireContext(), "FUNCIONA", Toast.LENGTH_SHORT).show()
    }

    /*private var doubleBackToExitPressedOnce = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (doubleBackToExitPressedOnce) {
                    requireActivity().finish()
                    return
                }

                this@LogInFragment.doubleBackToExitPressedOnce = true
                Toast.makeText(requireContext(), resources.getString(R.string.backAgain), Toast.LENGTH_SHORT).show()

                Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
            }
        })
    }*/

    val callback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            findNavController().navigate(R.id.logInFragmentToLoginSelectionFragment)
        }
    }


}