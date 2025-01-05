package com.S3246961venkat.hostelmanagment.activities

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.google.firebase.database.FirebaseDatabase
import com.S3246961venkat.hostelmanagment.R
import com.S3246961venkat.hostelmanagment.ResidentDetails
import com.S3246961venkat.hostelmanagment.activities.SelectHostel.hostel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookingScreen(hostel)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(hostel: HostelData) {
    val appContext = LocalContext.current as BookingActivity

    var weeks by remember { mutableStateOf("") }
    var totalCost by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.p1))
                .padding(vertical = 6.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back",
                modifier = Modifier
                    .clickable {
                        appContext.finish()


                    }
                    .padding(start = 4.dp) // Optional spacing // Optional spacin
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Book Hostel",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        }


        // Input for No of Weeks
        OutlinedTextField(
            value = weeks,
            onValueChange = { weeks = it },
            label = { Text("No of Weeks") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true, // Ensures single-line input
            modifier = Modifier
                .fillMaxWidth()

                .padding(vertical = 8.dp, horizontal = 12.dp), // Adds spacing around the field
            shape = RoundedCornerShape(8.dp), // Rounded corners for the field
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.surface, // Background color
                focusedBorderColor = MaterialTheme.colorScheme.primary, // Color when focused
                unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f), // Color when not focused
                focusedTextColor = MaterialTheme.colorScheme.onSurface, // Text color
                cursorColor = MaterialTheme.colorScheme.primary, // Cursor color
                focusedLabelColor = MaterialTheme.colorScheme.primary // Label color when focused
            ),
            textStyle = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface)
        )


        // Input for Name

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp,horizontal = 12.dp),

            // Padding inside the container
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Name : ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = ResidentDetails.getResidentName(appContext)!!,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        // Hostel Name Text
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp,horizontal = 12.dp),
            // Padding inside the container
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Hostel Name: ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = hostel.hostelname,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp,horizontal = 12.dp),
            // Padding inside the container
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Weeks : £ ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = weeks,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp,horizontal = 12.dp),
            // Padding inside the container
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Cost : ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Text(
                text =
                    if(weeks.isNotEmpty())
                    {
                        (weeks.toInt() * hostel.hostelprice).toString()
                    }else{
                        "Enter Weeks"
                    }
                ,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }


        // Book Button
        Button(
            onClick = {

                if (weeks.isBlank()) {
                    Toast.makeText(appContext, "Enter No Of Weeks", Toast.LENGTH_SHORT).show()
                } else {
                    val current = LocalDateTime.now()
                    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                    val dateFormatted = current.format(formatter)

                    hostel.guestName = ResidentDetails.getResidentName(appContext)!!
                    hostel.bookingWeeks = weeks
                    hostel.bookingCost = (weeks.toInt() * hostel.hostelprice).toString()
                    hostel.bookingDate=dateFormatted

                    saveHostel(hostel, appContext)
                }

                // Use the captured appContext inside onClick
                Toast.makeText(appContext, "Booking Successful", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
            shape = RoundedCornerShape(8.dp),


            ) {
            Text(text = "Book", color = Color.White)
        }
    }
}


private fun saveHostel(hostel: HostelData, appContext: Context) {

    val firebaseDatabase = FirebaseDatabase.getInstance()
    val databaseReference = firebaseDatabase.getReference("HostelSavings")

    val residentEmail = ResidentDetails.getResidentEmail(appContext)!!

    databaseReference.child(residentEmail.replace(".", ",")).child(hostel.hostelId.toString()).setValue(hostel)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {

                (appContext as Activity).finish()
                Toast.makeText(appContext, "Hostel Reserved Successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    appContext,
                    "Hostel Booking Failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        .addOnFailureListener { exception ->
            Toast.makeText(
                appContext,
                "Something went wrong while booking your hostel",
                Toast.LENGTH_SHORT
            ).show()
        }
}






