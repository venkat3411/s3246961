package com.example.hostelmanagment

import android.content.Context

object ResidentDetails {

    private const val PREFS_NAME = "HostelManagementData"

    fun saveResidentLoginStatus(context: Context, value: Boolean) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("LOGIN_STATUS", value).apply()
    }

    fun getResidentLoginStatus(context: Context): Boolean {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getBoolean("LOGIN_STATUS", false)
    }

    fun saveResidentName(context: Context, name: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("USER_NAME", name).apply()
    }

    fun getResidentName(context: Context): String? {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString("USER_NAME", null)
    }

    fun saveResidentEmail(context: Context, email: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("USER_EMAIL", email).apply()
    }

    fun getResidentEmail(context: Context): String? {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString("USER_EMAIL", null)
    }
}
