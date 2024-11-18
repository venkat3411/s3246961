package com.example.hostelmanagment.activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hostelmanagment.R

class HostelDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HDetails()
        }
    }
}
@Composable
fun HDetails() {

    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        contentAlignment = Alignment.TopCenter

    )
    {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center

        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    painter = painterResource(id = R.drawable.hostel_rooms),
                    contentDescription = "AI Doctor",
                    Modifier
                        .width(150.dp)
                        .height(150.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                // Space between image and texts

                Column {
                    Text(
                        text = "Hostel Name",
                        color = Color.Blue,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold
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
                        )
                        Spacer(modifier = Modifier.width(4.dp))


                        Text(
                            text = "Address",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,


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
                        )
                        Spacer(modifier = Modifier.width(4.dp))


                        Text(
                            text = "Wifi",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,


                            )
                        Spacer(modifier = Modifier.width(6.dp))

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
                                text = "Mess",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,


                                )
                            Spacer(modifier = Modifier.width(6.dp))

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
                                    text = "AC",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,


                                    )


                            }
                        }

                    }


                }

            }

            Column(
                modifier = Modifier.padding(12.dp, 8.dp)
            ) {
                Text(
                    text = "Price Details",
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,

                    )
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )

                {
                    Text(text = "1 Occupancy")
                    Text(text = "Rupees 7,000")
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )

                {
                    Text(text = "2 Occupancy")
                    Text(text = "Rupees 4,000")
                }
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )

                {
                    Text(text = "3 Occupancy")
                    Text(text = "Rupees 2,000")
                }
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )

                {
                    Text(text = "4 Occupancy")
                    Text(text = "Rupees 500")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Select Rooms",
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,

                    )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly // Adjust arrangement if needed
                ) {
                    // First Box
                    Box(
                        modifier = Modifier
                            .weight(1f) // Distribute space evenly between boxes
                            .padding(4.dp)
                            .background(Color.LightGray)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "1 Occupancy",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Second Box
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .background(Color.LightGray)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "2 Occupancy",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )


                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly // Adjust arrangement if needed
                ) {
                    // First Box
                    Box(
                        modifier = Modifier
                            .weight(1f) // Distribute space evenly between boxes
                            .padding(4.dp)
                            .background(Color.LightGray)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "3 Occupancy",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Second Box
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .background(Color.LightGray)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "4 Occupancy",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )

                    }


                }


            }


        }
    }
}




