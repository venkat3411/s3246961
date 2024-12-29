package com.S3246961venkat.hostelmanagment.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.S3246961venkat.hostelmanagment.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

class ViewMapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HostelLocations()
        }
    }
}


@Composable
fun HostelLocations() {

    val cornellQuarterLocation = LatLng(54.5706759, -1.2329553)
    val kingEdwardsSquareLocation = LatLng(54.572131, -1.236565)
    val woodlandsHallsLocation = LatLng(54.5697724, -1.2380322)
    val westParksideVillageLocation = LatLng(54.567245, -1.233067)
    val parksideEastLocation = LatLng(54.567048, -1.232399)
    val parksideHallsofResidenceLocation = LatLng(54.567373, -1.232581)


    val cameraPositionState = rememberCameraPositionState {
        position =
            CameraPosition.fromLatLngZoom(cornellQuarterLocation, 14f) // Focused on Cornell Quarter
    }

    val context = LocalContext.current as Activity
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
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
                        context.finish()


                    }
                    .padding(start = 4.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Hostel Locations",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {


            Marker(
                state = rememberMarkerState(position = cornellQuarterLocation),
                title = "Cornell Quarter",
                onClick = {
                    SelectHostel.hostel = getHostelData()[0]
                    context.startActivity(Intent(context, HostelDetailsActivity::class.java))
                    false
                }
            )

            Marker(
                state = rememberMarkerState(position = kingEdwardsSquareLocation),
                title = "King Edward's Square",
                onClick = {
                    SelectHostel.hostel = getHostelData()[1]
                    context.startActivity(Intent(context, HostelDetailsActivity::class.java))
                    false
                }
            )

            Marker(
                state = rememberMarkerState(position = woodlandsHallsLocation),
                title = "Woodlands Halls",
                onClick = {
                    SelectHostel.hostel = getHostelData()[2]
                    context.startActivity(Intent(context, HostelDetailsActivity::class.java))
                    false
                }
            )

            Marker(
                state = rememberMarkerState(position = westParksideVillageLocation),
                title = "West ParkSide Village",
                onClick = {
                    SelectHostel.hostel = getHostelData()[3]
                    context.startActivity(Intent(context, HostelDetailsActivity::class.java))
                    false
                }
            )

            Marker(
                state = rememberMarkerState(position = parksideEastLocation),
                title = "East ParkSide Village",
                onClick = {
                    SelectHostel.hostel = getHostelData()[4]
                    context.startActivity(Intent(context, HostelDetailsActivity::class.java))
                    false
                }
            )

            Marker(
                state = rememberMarkerState(position = parksideHallsofResidenceLocation),
                title = "ParkSide Halls",
                onClick = {
                    SelectHostel.hostel = getHostelData()[5]
                    context.startActivity(Intent(context, HostelDetailsActivity::class.java))
                    false
                }
            )
        }
    }
}
