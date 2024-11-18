package com.example.hostelmanagment.activities

data class HostelData(
    val hostelname: String = "",
    val hostellocation: String = "",
    val hostelcontact: String = "",
    val hosteldescription: String = "",
    val hostelimage: Int=0,
    val hostelprice: Int = 0,
    val hosteltype: String = "",
    val hostelfacilities: String = "",
    val hostelrating: String = "",
    val hostelreviews: String = "",
    val totalrooms: Int=0,
    val availablerooms: Int=0,

)
