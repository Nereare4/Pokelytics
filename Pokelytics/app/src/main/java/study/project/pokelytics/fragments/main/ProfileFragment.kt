package study.project.pokelytics.fragments.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import study.project.pokelytics.R
import study.project.pokelytics.activities.ActivityBase
import study.project.pokelytics.databinding.FragmentProfileBinding
import study.project.pokelytics.fragments.FragmentBase
import study.project.pokelytics.models.User
import study.project.pokelytics.services.KeyConstants
import study.project.pokelytics.services.PreferenceService

class ProfileFragment : FragmentBase<FragmentProfileBinding>() {

    private val fAuth: FirebaseAuth by inject()
    private val fStore: FirebaseFirestore by inject()
    private lateinit var preferenceService: PreferenceService
    override fun getResourceLayout(): Int = R.layout.fragment_profile

    override fun initializeView() {
        val photoUser = fAuth.currentUser?.photoUrl
        val nameUser = fAuth.currentUser?.displayName
        val emailUser = preferenceService.getPreference(KeyConstants.EMAIL_KEY)

        binding.apply {
            profileName.text = nameUser
            Picasso.get().load(photoUser).into(profileImage)
            profileEmail.text = emailUser
            logOut.setOnClickListener{
                preferenceService.removePreference(KeyConstants.EMAIL_KEY)
                fAuth.signOut()
                (activity as ActivityBase<*>).navigator.goToMain(User.getDefaultUser())
            }
            deleteAccount.setOnClickListener(){
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle(resources.getString(R.string.deleteaccount))
                builder.setMessage(resources.getString(R.string.deleteAccountQuestion))
                builder.setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                    if (emailUser != null) {
                        fStore.collection("users").document(emailUser).delete()
                    }
                    fAuth.currentUser?.delete()
                    Toast.makeText(requireContext(), resources.getString(R.string.deleteAccountSuccesful), Toast.LENGTH_LONG).show()
                    preferenceService.removePreference(KeyConstants.EMAIL_KEY)
                    (activity as ActivityBase<*>).navigator.goToLogin()
                }
                builder.setNegativeButton(resources.getString(R.string.cancel)) { dialog, which ->}
                builder.show()
            }
            privacyPolicy.setOnClickListener(){
                (activity as ActivityBase<*>).navigator.goToPolicy()
            }
        }


    }

    override fun bindViewModel() {
        binding.apply {
            lifecycleOwner = this@ProfileFragment
        }
    }

    override fun subscribe() {
    }

}