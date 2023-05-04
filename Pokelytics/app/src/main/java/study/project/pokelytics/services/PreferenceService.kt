package study.project.pokelytics.services

import android.content.SharedPreferences

class PreferenceService (
        private val sharedPreferences: SharedPreferences
    ){
        fun savePreference(key: String, value: String?){}
        fun removePreference(key: String){}
        fun getPreference(key: String): String?{
            return ""
        }
}