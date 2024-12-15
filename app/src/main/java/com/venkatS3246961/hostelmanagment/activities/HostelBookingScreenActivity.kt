package com.venkatS3246961.hostelmanagment.activities

import android.app.Activity
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.venkatS3246961.hostelmanagment.R
import com.venkatS3246961.hostelmanagment.ResidentDetails
import com.venkatS3246961.hostelmanagment.ui.theme.HostelManagmentTheme

class HostelBookingScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HostelManagmentTheme {
                HostelBookingSelection()

            }
        }
    }


}

fun getSavedHostels(residentEmail: String, onHostelsFetched: (List<HostelData>) -> Unit) {

    val emailKey = residentEmail.replace(".", ",")

    val databaseReference = FirebaseDatabase.getInstance().getReference("HostelSavings/$emailKey")

    databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val bookedHostels = mutableListOf<HostelData>()
            for (donationSnapshot in snapshot.children) {
                val donation = donationSnapshot.getValue(HostelData::class.java)
                donation?.let { bookedHostels.add(it) }
            }
            onHostelsFetched(bookedHostels)
        }

        override fun onCancelled(error: DatabaseError) {
            println("Error: ${error.message}")
            onHostelsFetched(emptyList()) // Return an empty list in case of error
        }
    })
}


@Composable
fun HostelBookingScreen(hostelData: HostelData) {

    Card(
        modifier = Modifier
            .fillMaxWidth(), // Outer padding for the card
        shape = RoundedCornerShape(12.dp), // Rounded corners for the card
        elevation = CardDefaults.cardElevation(4.dp), // Adds shadow for a raised effect
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // Card background color
        )
    )
    {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp), // Add padding for better spacing
            verticalArrangement = Arrangement.spacedBy(4.dp) // Space out elements
        ) {
            // Image filling max width and fixed height of 200dp
            Image(
                painter = painterResource(id = R.drawable.h1_cornell), // Replace with your image resource
                contentDescription = "Hostel Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop // Crop the image to fill the space
            )

            // Hostel Name Text
            Text(
                text = hostelData.hostelname, // Replace with the actual hostel name
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth()
            )

            // Booked For Duration Text
            Text(
                text = "Booked For : ${hostelData.bookingWeeks} weeks", // Replace with dynamic duration if needed
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Total Cost : £ ${hostelData.bookingCost}", // Replace with dynamic duration if needed
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth()
            )

            // Date of Booking Text
            Text(
                text = "Date of Booking: ${hostelData.bookingDate}", // Replace with dynamic date if needed
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun HostelBookingSelection() {
    val context = LocalContext.current

    val residentEmail = ResidentDetails.getResidentEmail(context)!!

    var hostels by remember { mutableStateOf(listOf<HostelData>()) }

    // Fetch orders
    LaunchedEffect(residentEmail) {
        getSavedHostels(residentEmail) { bookedHostels ->
            hostels = bookedHostels
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.p1))
                .padding(vertical = 6.dp, horizontal = 16.dp),
            // Space between elements in the row
            verticalAlignment = Alignment.CenterVertically, // Align vertically to center
        ) {
            Image(painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back",
                modifier = Modifier
                    .clickable {
                        (context as Activity).finish()
                    }
                    .padding(start = 4.dp) // Optional spacing // Optional spacin
            )
            Spacer(modifier = Modifier.width(16.dp))


            Text(
                text = "Hostel Bookings",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.p2)
            )
        }

        if(hostels.isEmpty())
        {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "You didn't book any hostels",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.black)
            )
            Spacer(modifier = Modifier.weight(1f))
        }else {
            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {

                items(hostels.size) { index ->
                    HostelBookingScreen(hostelData = hostels[index])
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

    }
}



