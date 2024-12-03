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
            hostelname = "Cornell Quarter",
            hostellocation = "City Center, City A",
            hostelcontact = "123-111-2233",
            hosteldescription = "The Cornell Quarter is on the doorstep of the University, and just a seven-minute walk to the centre of town with its shops, restaurants and amenities. It's close to the centre of campus, which makes it handy for lectures, the Library, student support services and the Students' Union.",
            hostelimage = R.drawable.h1_cornell, // Replace with actual drawable
            hostelprice = 8000,
            hostelimage1 = R.drawable.baseline_business_24,
            hostelimage2 = R.drawable.baseline_pentagon_24,
            hostelimage3 = R.drawable.baseline_directions_walk_24,
            hostelimage4 = R.drawable.baseline_shower_24,
            hostelimage5 = R.drawable.baseline_bed_24,
            hostelimage6 = R.drawable.baseline_content_paste_24,
            hostelimage7 = R.drawable.baseline_wifi_24,
            hostelimage8 = R.drawable.baseline_local_laundry_service_24,
            hostelimage9 = R.drawable.baseline_local_movies_24,
            hostelimage10 = R.drawable.baseline_personal_injury_24,
            hostelimage11 = R.drawable.baseline_newspaper_24,
            hostelimage12 = R.drawable.baseline_tv_24,
            boldtext1 = "300",
            boldtext2 = "£165",
            boldtext3 = "1",
            boldtext4 = "En-suite\n",
            boldtext5 = "Double\n",
            boldtext6 = "Free insurance\n",
            boldtext7 = "Free Wi-Fi\n",
            boldtext8 = "Laundry\n",
            boldtext9 = "Free gym & cinema room",
            boldtext10 = "Wardens",
            boldtext11 = "Bills\n",
            boldtext12 = "Free TV\n",
            normaltext1 = "\nspaces",
            normaltext2 = "\na week",
            normaltext3 = "minute\n from campus",
            normaltext4 = "single rooms",
            normaltext5 = "small double\n beds",
            normaltext6 = "for student \ncontents",
            normaltext7 = "speed of upto 1GB",
            normaltext8 = "facilities on-site",

            normaltext10 = "live in student wardens",
            normaltext11 = "included",
            normaltext12 = "in kitchen/diner",

            hosteltype = "Co-Ed",
            hostelfacilities = "Wi-Fi, Gym, Swimming Pool, Library",
            hostelrating = "4.8",
            hostelreviews = "Amazing environment with supportive staff.",
            totalrooms = 60,
            availablerooms = 15,
            featureList = listOf(
                FeaturesData(R.drawable.baseline_shower_24, "En-Suite", "Single rooms"),
                FeaturesData(R.drawable.baseline_bed_24, "Double", "small double beds"),
                FeaturesData(R.drawable.baseline_content_paste_24, "Free insurance", "for student contents"),
                FeaturesData(R.drawable.baseline_wifi_24, "Free Wi-Fi", "speed of upto 1GB"),
                FeaturesData(R.drawable.baseline_local_laundry_service_24, "Laundry", "facilities on-site"),
                FeaturesData(R.drawable.baseline_local_movies_24, "Free gym & cinema room", ),
                FeaturesData(R.drawable.baseline_personal_injury_24, "Wardens", "live in student wardens"),
                FeaturesData(R.drawable.baseline_newspaper_24, "Bills", "included"),
                FeaturesData(R.drawable.baseline_tv_24, "Free TV", "in kitchen/diner"),




            )
        ),
        HostelData(
            hostelname = "King Edward's Square",
            hostelimage1 = R.drawable.baseline_business_24,
            hostelimage2 = R.drawable.baseline_pentagon_24,
            hostelimage3 = R.drawable.baseline_directions_walk_24,
            hostelimage4 = R.drawable.baseline_home_24,
            hostelimage5 = R.drawable.baseline_shower_24,
            hostelimage6 = R.drawable.baseline_content_paste_24,
            hostelimage7 = R.drawable.baseline_wifi_24,
            hostelimage8 = R.drawable.baseline_local_laundry_service_24,
            hostelimage9 = R.drawable.baseline_tv_24,
            hostelimage10 = R.drawable.baseline_personal_injury_24,
            hostelimage11 = R.drawable.baseline_newspaper_24,
            hostelimage12 = R.drawable.baseline_local_dining_24,
            boldtext1 = "87",
            boldtext2 = "£150",
            boldtext22 = "£140",
            boldtext3 = "on campus",
            boldtext4 = "Individual houses\n",
            boldtext5 = "En-suite\n",
            boldtext6 = "Free insurance\n",
            boldtext7 = "Free Wi-Fi\n",
            boldtext8 = "Laundry\n",
            boldtext9 = "Free TV\n",
            boldtext10 = "Wardens\n",
            boldtext11 = "Bills\n",
            boldtext12 = "Kitchen/diner\n",
            normaltext1 = "\nspaces",
            normaltext2 = "\na week(en-suite)",

            normaltext4 = "set around a central green",
            normaltext5 = "single rooms",
            normaltext6 = "for student contents",
            normaltext7 = "speed of upto \n1GB",
            normaltext8 = "facilities on-site",
            normaltext9 = "in kitchen/diner",
            normaltext10 = "live-in student wardens",
            normaltext11 = "included",
            normaltext12 = "shared use",

            hostellocation = "Urban Area, City B",
            hostelcontact = "987-111-2222",
            hosteldescription = "With a village-square feel, King Edward's Square (KES) has 15 houses set around a central green. Sitting on the grass outside the houses is a great way to spend time with friends. Because of its great central location, KES (as it's known) is really handy for lectures, the library, student support services and Students' Union. You step out of KES into the town centre with its shops, restaurants and amenities.",
            hostelimage = R.drawable.h2_kingedwards, // Replace with actual drawable
            hostelprice = 4000,
            hosteltype = "Boys Only",
            hostelfacilities = "Cafeteria, Wi-Fi, Parking",
            hostelrating = "4.2",
            hostelreviews = "Great for students with limited budgets.",
            totalrooms = 75,
            availablerooms = 20,
            featureList = listOf
                (FeaturesData(R.drawable.baseline_home_24, "Individual houses", "set around a central green"),
            FeaturesData(R.drawable.baseline_shower_24, "En-suite", "single rooms" ),
            FeaturesData(R.drawable.baseline_content_paste_24, "Free insurance", "for student contents"),
            FeaturesData(R.drawable.baseline_wifi_24, "Free Wi-Fi", "speed of upto 1GB"),
            FeaturesData(R.drawable.baseline_local_laundry_service_24, "Laundry", "facilities on-site"),
            FeaturesData(R.drawable.baseline_tv_24, "Free TV", "in kitchen/diner" ),
            FeaturesData(R.drawable.baseline_personal_injury_24, "Wardens", "live in student wardens"),
            FeaturesData(R.drawable.baseline_newspaper_24, "Bills", "included"),
            FeaturesData(R.drawable.baseline_local_dining_24, "Kitchen/diner", "shared use"),

            )
        ),
        HostelData(
            hostelname = "Woodlands Halls",
            hostelimage1 = R.drawable.baseline_business_24,
            hostelimage2 = R.drawable.baseline_pentagon_24,
            hostelimage3 = R.drawable.baseline_directions_walk_24,
            hostelimage4 = R.drawable.baseline_home_24,
            hostelimage5 = R.drawable.baseline_bed_24,
            hostelimage6 = R.drawable.baseline_content_paste_24,
            hostelimage7 = R.drawable.baseline_wifi_24,
            hostelimage8 = R.drawable.baseline_local_laundry_service_24,
            hostelimage9 = R.drawable.baseline_personal_injury_24,
            hostelimage10 = R.drawable.baseline_newspaper_24,
            hostelimage11 = R.drawable.baseline_local_dining_24,
            hostelimage12 = R.drawable.baseline_tv_24,
            boldtext1 = "252",
            boldtext2 = "£105",
            boldtext3 = "on campus",
            boldtext4 = "7 Individual halls\n",
            boldtext5 = "Single\n",
            boldtext6 = "Free insurance\n",
            boldtext7 = "Free Wi-Fi\n",
            boldtext8 = "Laundry\n",
            boldtext9 = "Wardens\n",
            boldtext10 = "Bills\n",
            boldtext11 = "Kitchen\n",

            normaltext1 = "\nspaces",
            normaltext2 = "\na week",

            normaltext4 = "of 36 rooms in each, located in the middle of campus",
            normaltext5 = "en-suite rooms",
            normaltext6 = "for student \ncontents",
            normaltext7 = "speed of upto \n1GB",
            normaltext8 = "facilities on-site",
            normaltext9 = "live in student wardens",
            normaltext10 = "included",
            normaltext11 = "shared use",


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
            availablerooms = 8,
                    featureList = listOf
                    (FeaturesData(R.drawable.baseline_home_24, "7 Individual halls", "of 36 rooms in each, located in the middle of campus"),
            FeaturesData(R.drawable.baseline_bed_24, "Single", "en-suite rooms" ),
            FeaturesData(R.drawable.baseline_content_paste_24, "Free insurance", "for student contents"),
            FeaturesData(R.drawable.baseline_wifi_24, "Free Wi-Fi", "speed of upto 1GB"),
            FeaturesData(R.drawable.baseline_local_laundry_service_24, "Laundry", "facilities on-site"),
            FeaturesData(R.drawable.baseline_personal_injury_24, "Wardens", "live in student wardens" ),
            FeaturesData(R.drawable.baseline_newspaper_24, "Bills", "included"),
            FeaturesData(R.drawable.baseline_local_dining_24, "Kitchen", "shared use"),





            )
        ),
        HostelData(
            hostelname = "West Parkside Village",
            hostelimage1 = R.drawable.baseline_business_24,
            hostelimage2 = R.drawable.baseline_pentagon_24,
            hostelimage3 = R.drawable.baseline_directions_walk_24,
            hostelimage4 = R.drawable.baseline_home_24,
            hostelimage5 = R.drawable.baseline_shower_24,
            hostelimage6 = R.drawable.baseline_bed_24,
            hostelimage7 = R.drawable.baseline_tv_24,
            hostelimage8 = R.drawable.baseline_wifi_24,
            hostelimage9 = R.drawable.baseline_local_laundry_service_24,
            hostelimage10 = R.drawable.baseline_content_paste_24,
            hostelimage11 = R.drawable.baseline_personal_injury_24,
            hostelimage12 = R.drawable.baseline_newspaper_24,
            hostelimage13 = R.drawable.baseline_local_dining_24,
            boldtext1 = "80",
            boldtext2 = "£100",
            boldtext3 = "3-4",
            boldtext4 = "16 individual houses\n",
            boldtext5 = "Bathroom\n",
            boldtext6 = "Single\n",
            boldtext7 = "Free TV\n",
            boldtext8 = "Free Wi-Fi\n",
            boldtext9 = "Laundry\n",
            boldtext10 = "Free insurance\n",
            boldtext11 = "Wardens\n",
            boldtext12 = "Bills\n",
            boldtext13 = "Kitchen/diner\n",
            normaltext1 = "\nspaces",
            normaltext2 = "\na week",
            normaltext3 = "minutes\n from campus",
            normaltext4 = "of 5 rooms per house set on the edge of Albert Park",
            normaltext5 = "shared",
            normaltext6 = "rooms",
            normaltext7 = "kitchen/diner\n and living room",
            normaltext8 = "speed of up to\n 1GB",
            normaltext9 = "facilities on-site",
            normaltext10 = "for student\n contents",
            normaltext11 = "live-in student wardens",
            normaltext12 = "included",
            normaltext13 = "shared use",

            hostellocation = "City Center, City D",
            hostelcontact = "555-111-4444",
            hosteldescription = "For those preferring a quieter location, West Parkside Village is ideal, located on the southern edge of campus. It’s made up of 16 houses each for five people, giving a close-knit village feel. It’s perfect for those on placements with on-site parking available. Facing Middlesbrough's Albert Park with its wide range of facilities including a roller skating rink, café, lake, weekly park runs, tennis courts and bowling greens, it’s an ideal place for you if you love the outdoor life.",
            hostelimage = R.drawable.h4_westparkside,
            hostelprice = 9000,
            hosteltype = "Co-Ed",
            hostelfacilities = "Wi-Fi, AC Rooms, Rooftop Cafeteria",
            hostelrating = "4.9",
            hostelreviews = "Excellent location and facilities.",
            totalrooms = 100,
            availablerooms = 5,
            featureList = listOf
                (FeaturesData(R.drawable.baseline_home_24, "16 individual houses", "of 5 rooms per house set on the edge of Albert Park"),
                FeaturesData(R.drawable.baseline_shower_24, "Bathroom", "shared" ),
                FeaturesData(R.drawable.baseline_bed_24, "Single", "rooms"),
                FeaturesData(R.drawable.baseline_tv_24, "Free TV", "kitchen/diner and living room"),
                FeaturesData(R.drawable.baseline_wifi_24, "Free Wi-Fi", "speed of up to 1GB"),
                FeaturesData(R.drawable.baseline_local_laundry_service_24, "Laundry", "live-in student wardens" ),
                FeaturesData(R.drawable.baseline_content_paste_24, "Free insurance", "for student contents"),
                FeaturesData(R.drawable.baseline_personal_injury_24, "Wardens", "live in student wardens"),
                FeaturesData(R.drawable.baseline_newspaper_24, "Bills", "included"),
                FeaturesData(R.drawable.baseline_local_dining_24, "Kitchen/diner", "shared use"),

                        )

        ),
        HostelData(
            hostelname = "East Parkside Village",
            hostellocation = "City E",
            hostelcontact = "777-888-9999",
            hostelimage1 = R.drawable.baseline_business_24,
            hostelimage2 = R.drawable.baseline_pentagon_24,
            hostelimage3 = R.drawable.baseline_directions_walk_24,
            hostelimage4 = R.drawable.baseline_home_24,
            hostelimage5 = R.drawable.baseline_bed_24,
            hostelimage6 = R.drawable.baseline_content_paste_24,
            hostelimage7 = R.drawable.baseline_wifi_24,
            hostelimage8 = R.drawable.baseline_local_laundry_service_24,
            hostelimage9 = R.drawable.baseline_personal_injury_24,
            hostelimage10 = R.drawable.baseline_newspaper_24,
            hostelimage11 = R.drawable.baseline_local_dining_24,
            boldtext1 = "108",
            boldtext2 = "£100",
            boldtext3 = "4-5",
            boldtext4 = "Individual houses and flats\n",
            boldtext5 = "Single rooms\n",
            boldtext6 = "Free insurance\n",
            boldtext7 = "Free Wi-Fi\n",
            boldtext8 = "Laundry\n",
            boldtext9 = "Wardens\n",
            boldtext10 = "Bills\n",
            boldtext11 = "Kitchen/diner\n",

            normaltext1 = "\nspaces",
            normaltext2 = "\na week",
            normaltext3 = "minutes\n from campus",
            normaltext4 = "set on the edge of of Albert Park",
            normaltext5 = "with shared bathroom",
            normaltext6 = "for student contents",
            normaltext7 = "speed of upto 1GB",
            normaltext8 = "facilities on-site",
            normaltext9 = "(live-in student wardens)",
            normaltext10 = "included",
            normaltext11 = "shared use",
            hosteldescription = "Located on the southern edge of campus, East Parkside Village is made up of houses for five people and four apartments with six people in each. Facing Middlesbrough's Albert Park with its wide range of facilities including a roller skating rink, café, lake, weekly park runs, tennis courts and bowling greens, it's an ideal place for you if you love the outdoor life.",
            hostelimage = R.drawable.h5_eastparkside,
            hostelprice = 5500,
            hosteltype = "Co-Ed",
            hostelfacilities = "Solar Power, Organic Cafeteria, Wi-Fi",
            hostelrating = "4.4",
            hostelreviews = "Perfect choice for eco-conscious residents.",
            totalrooms = 60,
            availablerooms = 12,
            featureList = listOf
                (FeaturesData(R.drawable.baseline_home_24, "Individual houses and flats", "set on the edge of Albert Park"),
                FeaturesData(R.drawable.baseline_bed_24, "Single rooms", "with shared bathroom" ),
                FeaturesData(R.drawable.baseline_content_paste_24, "Free insurance", "for student contents"),
                FeaturesData(R.drawable.baseline_wifi_24, "Free Wi-Fi", "speed of upto 1GB"),

                FeaturesData(R.drawable.baseline_local_laundry_service_24, "Laundry", "facilities on-site" ),
                FeaturesData(R.drawable.baseline_personal_injury_24, "Wardens", "live in student wardens"),
                FeaturesData(R.drawable.baseline_newspaper_24, "Bills", "included"),
                FeaturesData(R.drawable.baseline_local_dining_24, "Kitchen/diner", "shared use"),


                )
        ),
        HostelData(
            hostelname = "Parkside Halls",
            hostelimage1 = R.drawable.baseline_business_24,
            hostelimage2 = R.drawable.baseline_pentagon_24,
            hostelimage3 = R.drawable.baseline_directions_walk_24,
            hostelimage4 = R.drawable.baseline_content_paste_24,
            hostelimage5 = R.drawable.baseline_shower_24,
            hostelimage6 = R.drawable.baseline_bed_24,
            hostelimage7 = R.drawable.baseline_content_paste_24,
            hostelimage8 = R.drawable.baseline_wifi_24,
            hostelimage9 = R.drawable.baseline_local_laundry_service_24,
            hostelimage10 = R.drawable.baseline_personal_injury_24,
            hostelimage11 = R.drawable.baseline_newspaper_24,
            hostelimage12 = R.drawable.baseline_local_dining_24,
            boldtext1 = "85",
            boldtext2 = "£85",
            boldtext3 = "4-5",
            boldtext4 = "Budget\n",
            boldtext5 = "Bathroom\n",
            boldtext6 = "Single\n",
            boldtext7 = "Free insurance\n",
            boldtext8 = "Free Wi-fi\n",
            boldtext9 = "Laundry\n",
            boldtext10 = "Wardens\n",
            boldtext11 = "Bills\n",
            boldtext12 = "Kitchen/diner\n",
            normaltext1 = "\nspaces",
            normaltext2 = "\na week",
            normaltext3 = "minutes\n from campus",
            normaltext4 = "accommodation",
            normaltext5 = "shared",
            normaltext6 = "rooms",
            normaltext7 = "for student contents",
            normaltext8 = "speed of up to 1GB",
            normaltext9 = "facilities on-site",
            normaltext10 = "live in student wardens",
            normaltext11 = "included",
            normaltext12 = "shared use",

            hostellocation = "Downtown, City F",
            hostelcontact = "333-444-5555",
            hosteldescription = "Located on the southern edge of campus, Parkside Halls has a range of rooms. Set over three floors it's a very sociable place to live allowing you to easily mix with other students. Facing Middlesbrough's Albert Park with its wide range of facilities including a roller skating rink, café, lake, weekly park runs, tennis courts and bowling greens, it's an ideal place for you if you love the outdoor life.",
            hostelimage = R.drawable.h6_parksidehalls,
            hostelprice = 10000,
            hosteltype = "Co-Ed",
            hostelfacilities = "Wi-Fi, Gym, Rooftop Pool, AC",
            hostelrating = "4.7",
            hostelreviews = "Luxury living at its best.",
            totalrooms = 120,
            availablerooms = 15,
            featureList = listOf
                (FeaturesData(R.drawable.baseline_price_change_24, "Budget", "accommodation"),
                FeaturesData(R.drawable.baseline_shower_24, "Bathroom", "shared" ),
                FeaturesData(R.drawable.baseline_bed_24, "Single", "rooms"),
                FeaturesData(R.drawable.baseline_content_paste_24, "Free insurance", "for student contents"),

                FeaturesData(R.drawable.baseline_wifi_24, "Free Wi-Fi", "speed of upto 1GB" ),
                FeaturesData(R.drawable.baseline_local_laundry_service_24, "Laundry", "facilities on-site" ),
                FeaturesData(R.drawable.baseline_personal_injury_24, "Wardens", "live in student wardens"),
                FeaturesData(R.drawable.baseline_newspaper_24, "Bills", "included"),
                FeaturesData(R.drawable.baseline_local_dining_24, "Kitchen/diner", "shared use"),


                )
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
