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
    lateinit var preferenceService: PreferenceService



    override fun getResourceLayout(): Int = R.layout.fragment_welcome

    override fun initializeView() {
        binding.logOut.setOnClickListener{
            //PreferencesManager.getDefaultSharedPreferences(binding.root.context).wipe()
            preferenceService.removePreference(KeyConstants.EMAIL_KEY)
            fAuth.signOut()
            (activity as ActivityBase<*>).navigator.goToMain(User.getDefaultUser())
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