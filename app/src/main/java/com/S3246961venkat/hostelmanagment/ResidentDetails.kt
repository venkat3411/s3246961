package com.S3246961venkat.hostelmanagment

import android.content.Context

object ResidentDetails {

    private const val PREF_Resident = "HostelManagementData"

    fun saveResidentLoginStatus(context: Context, value: Boolean) {
        val residentLogin = context.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        val residentEditor = residentLogin.edit()
        residentEditor.putBoolean("RESIDENT_STATUS", value).apply()
    }

    fun getResidentLoginStatus(context: Context): Boolean {
        val residentLogin = context.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        return residentLogin.getBoolean("RESIDENT_STATUS", false)
    }

    fun saveResidentName(context: Context, name: String) {
        val residentName = context.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        val nameEditor = residentName.edit()
        nameEditor.putString("RESIDENT_NAME", name).apply()
    }

    fun getResidentName(context: Context): String? {
        val residentName = context.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        return residentName.getString("RESIDENT_NAME", null)
    }

    fun saveResidentEmail(context: Context, email: String) {
        val residentEmail = context.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        val emailEditor = residentEmail.edit()
        emailEditor.putString("RESIDENT_EMAIL", email).apply()
    }

    fun getResidentEmail(context: Context): String? {
        val residentEmail = context.getSharedPreferences(PREF_Resident, Context.MODE_PRIVATE)
        return residentEmail.getString("RESIDENT_EMAIL", null)
    }
}
