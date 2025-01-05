package com.S3246961venkat.hostelmanagment

import android.content.Context

object ResidentDetails {

    private const val PREF_Resident = "HostelManagementData"

    fun saveResidentLoginStatus(appContext: Context, value: Boolean) {
        val residentLogin = appContext.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        val residentEditor = residentLogin.edit()
        residentEditor.putBoolean("RESIDENT_LOGINS", value).apply()
    }

    fun getResidentLoginStatus(appContext: Context): Boolean {
        val residentLogin = appContext.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        return residentLogin.getBoolean("RESIDENT_LOGINS", false)
    }

    fun saveResidentName(appContext: Context, name: String) {
        val residentName = appContext.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        val nameEditor = residentName.edit()
        nameEditor.putString("RESIDENT_LOGINN", name).apply()
    }

    fun getResidentName(appContext: Context): String? {
        val residentName = appContext.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        return residentName.getString("RESIDENT_LOGINN", null)
    }

    fun saveResidentEmail(appContext: Context, email: String) {
        val residentEmail = appContext.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        val emailEditor = residentEmail.edit()
        emailEditor.putString("RESIDENT_LOGINE", email).apply()
    }

    fun getResidentEmail(appContext: Context): String? {
        val residentEmail = appContext.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        return residentEmail.getString("RESIDENT_LOGINE", null)
    }
}
