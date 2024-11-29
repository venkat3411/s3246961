package com.venkatS3246961.hostelmanagment.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat.requireContext
import com.venkatS3246961.hostelmanagment.R
import com.venkatS3246961.hostelmanagment.ResidentDetails
import com.venkatS3246961.hostelmanagment.SignInActivity
import com.venkatS3246961.hostelmanagment.ui.theme.HostelManagmentTheme

class MainDashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HostelManagmentTheme {
                HostelSelection(::gotoHostelDetails, ::onProfileClicked)
            }
        }
    }
    private fun onProfileClicked() {
    }


    private fun gotoHostelDetails(hostel: HostelData) {
        SelectHostel.hostel=hostel
        startActivity(Intent(this, HostelDetailsActivity::class.java))
    }

}


@Preview(showBackground = true)
@Composable
fun HostelPreview() {
    HostelSelection(onHostelSelected = {}, onProfileClicked = {})
}

@Composable
fun HostelSelection(onHostelSelected: (hostelData: HostelData) -> Unit,onProfileClicked: () -> Unit) {
    val hostels = getHostelData()
    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize()
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.p1))
                .padding(vertical = 6.dp, horizontal = 16.dp),
             // Space between elements in the row

            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.hostel_icon),
                contentDescription = "Hostel Icon",
                modifier = Modifier
                    .width(36.dp)
                    .height(36.dp)

            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Hostels",
                style = MaterialTheme.typography.titleLarge,
                color = colorResource(id = R.color.p2),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))

            Image(painter = painterResource(id = R.drawable.baseline_logout_24),
                contentDescription = "Logout",
                modifier = Modifier
                    .clickable {
                        // Navigate to LoginActivity when clicked
                        ResidentDetails.saveResidentLoginStatus(context, false)

                        val intent = Intent(context, SignInActivity::class.java)
                        context.startActivity(intent)
                         context.finish()
                    }
                    .padding(start = 8.dp) // Optional spacing // Optional spacin
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {

            items(hostels.size) { index ->
                HostelItemNew(hostelData = hostels[index], onHostelSelected = onHostelSelected)
            }
        }

    }
}


fun getHostelData(): List<HostelData> {
    return listOf(
        HostelData(
            hostelname = "Elite Stay Hostel",
            hostellocation = "City Center, City A",
            hostelcontact = "123-111-2233",
            hosteldescription = "Premium hostel with top-notch facilities for students.",
            hostelimage = R.drawable.h1_cornell, // Replace with actual drawable
            hostelprice = 8000,
            hosteltype = "Co-Ed",
            hostelfacilities = "Wi-Fi, Gym, Swimming Pool, Library",
            hostelrating = "4.8",
            hostelreviews = "Amazing environment with supportive staff.",
            totalrooms = 60,
            availablerooms = 15
        ),
        HostelData(
            hostelname = "Urban Nest Hostel",
            hostellocation = "Urban Area, City B",
            hostelcontact = "987-111-2222",
            hosteldescription = "Affordable and safe hostel for students and professionals.",
            hostelimage = R.drawable.h2_kingedwards, // Replace with actual drawable
            hostelprice = 4000,
            hosteltype = "Boys Only",
            hostelfacilities = "Cafeteria, Wi-Fi, Parking",
            hostelrating = "4.2",
            hostelreviews = "Great for students with limited budgets.",
            totalrooms = 75,
            availablerooms = 20
        ),
        HostelData(
            hostelname = "Serene Haven Hostel",
            hostellocation = "Hill View, City C",
            hostelcontact = "789-222-3333",
            hosteldescription = "Experience tranquility with scenic views and modern rooms.",
            hostelimage = R.drawable.h3_woodlands,
            hostelprice = 7500,
            hosteltype = "Girls Only",
            hostelfacilities = "Wi-Fi, Laundry, Garden Area, Gym",
            hostelrating = "4.6",
            hostelreviews = "Quiet and peaceful environment for studies.",
            totalrooms = 50,
            availablerooms = 8
        ),
        HostelData(
            hostelname = "Metropolitan Hostel",
            hostellocation = "City Center, City D",
            hostelcontact = "555-111-4444",
            hosteldescription = "Modern hostel in the heart of the city.",
            hostelimage = R.drawable.h4_westparkside,
            hostelprice = 9000,
            hosteltype = "Co-Ed",
            hostelfacilities = "Wi-Fi, AC Rooms, Rooftop Cafeteria",
            hostelrating = "4.9",
            hostelreviews = "Excellent location and facilities.",
            totalrooms = 100,
            availablerooms = 5
        ),
        HostelData(
            hostelname = "Green Leaf Hostel",
            hostellocation = "City E",
            hostelcontact = "777-888-9999",
            hosteldescription = "Eco-friendly hostel with sustainable amenities.",
            hostelimage = R.drawable.h5_eastparkside,
            hostelprice = 5500,
            hosteltype = "Co-Ed",
            hostelfacilities = "Solar Power, Organic Cafeteria, Wi-Fi",
            hostelrating = "4.4",
            hostelreviews = "Perfect choice for eco-conscious residents.",
            totalrooms = 60,
            availablerooms = 12
        ),
        HostelData(
            hostelname = "Skyline Hostel",
            hostellocation = "Downtown, City F",
            hostelcontact = "333-444-5555",
            hosteldescription = "High-rise hostel with stunning city views.",
            hostelimage = R.drawable.h6_parksidehalls,
            hostelprice = 10000,
            hosteltype = "Co-Ed",
            hostelfacilities = "Wi-Fi, Gym, Rooftop Pool, AC",
            hostelrating = "4.7",
            hostelreviews = "Luxury living at its best.",
            totalrooms = 120,
            availablerooms = 15
        )
    )
}


@Composable
fun HostelItemNew(hostelData: HostelData, onHostelSelected: (hostelData: HostelData) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp)
            .clickable { onHostelSelected.invoke(hostelData) },
        elevation = CardDefaults.cardElevation(4.dp),
    )
    {
        Image(
            painter = painterResource(id = hostelData.hostelimage),
            contentDescription = "Hostel Management",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

    }
}

@Composable
fun HostelBookingItem(hostelData: HostelData, onHostelSelected: (hostelData: HostelData) -> Unit) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onHostelSelected.invoke(hostelData) },
        elevation = CardDefaults.cardElevation(4.dp),
    )
    {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                painter = painterResource(id = hostelData.hostelimage),
                contentDescription = "Hostel Management",
                modifier = Modifier
                    .size(100.dp),
                contentScale = ContentScale.FillBounds
            )



            Spacer(modifier = Modifier.width(6.dp))
            // Space between image and texts

            Column {

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = hostelData.hostelname,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                )
                {

                    Image(
                        painter = painterResource(id = R.drawable.baseline_location_on_24),
                        contentDescription = "Location",
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))


                    Text(
                        text = hostelData.hostellocation,
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                )
                {

                    Image(
                        painter = painterResource(id = R.drawable.baseline_wifi_24),
                        contentDescription = "Wifi",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))


                    Text(
                        text = hostelData.hostelfacilities,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,


                        )
                    Spacer(modifier = Modifier.width(6.dp))


                }

                /*
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically
                )
                {

                    Image(
                        painter = painterResource(id = R.drawable.baseline_dinner_dining_24),
                        contentDescription = "Dinner",
                    )
                    Spacer(modifier = Modifier.width(4.dp))


                    Text(
                        text = hostelData.hostelcontact,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,


                        )
                    Spacer(modifier = Modifier.width(6.dp))

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically
                )
                {

                    Image(
                        painter = painterResource(id = R.drawable.baseline_ac_unit_24),
                        contentDescription = "Ac",
                    )
                    Spacer(modifier = Modifier.width(4.dp))


                    Text(
                        text = hostelData.hosteldescription,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,


                        )


                }

                */


                /*
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp, 0.dp),

                    )
                {
                    Button(
                        onClick = {
                            val intent = Intent(context, HostelDetailsActivity::class.java)
                            context.startActivity(intent)
                        },
                        modifier = Modifier,
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(text = "View")
                    }
                }

                */


            }
        }
    }
}
