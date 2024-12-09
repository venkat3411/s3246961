package com.venkatS3246961.hostelmanagment.activities

import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.venkatS3246961.hostelmanagment.R

class HostelDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HostelDetails(SelectHostel.hostel)
        }
    }
}

@Composable
fun HDetails() {

    val context = LocalContext.current as Activity
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        contentAlignment = Alignment.TopCenter

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(vertical = 6.dp, horizontal = 16.dp),
            // Space between elements in the row
            verticalAlignment = Alignment.CenterVertically, // Align vertically to center
        ) {
            Image(painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back",
                modifier = Modifier
                    .clickable {
                        context.finish()


                    }
                    .padding(start = 4.dp) // Optional spacing // Optional spacin
            )
            Spacer(modifier = Modifier.width(16.dp))


            Text(
                text = "Hostel Details",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }
    }






    Column(
        horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center

    )

    {
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically

        )

        {
            Image(
                painter = painterResource(id = R.drawable.hostel_rooms),
                contentDescription = "Hostel Image",
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
                    modifier = Modifier.fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically
                ) {

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
                    modifier = Modifier.fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically
                ) {

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
                        modifier = Modifier.fillMaxWidth(),

                        verticalAlignment = Alignment.CenterVertically
                    ) {

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
                            modifier = Modifier.fillMaxWidth(),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

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
                        .padding(16.dp), contentAlignment = Alignment.Center
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
                        .padding(16.dp), contentAlignment = Alignment.Center
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

@Composable
fun HostelDetails(hostel: HostelData) {
    val context = LocalContext.current as Activity
    //  val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Row with Back Arrow and Hostel Details Text
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
                    .padding(start = 4.dp) // Optional spacing // Optional spacin
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Hostel Details",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        }

        // Image Section with Arrows and Overlay Text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            // Background Image
            Image(
                painter = painterResource(id = hostel.hostelimage), // Replace with your image resource
                contentDescription = "Hostel Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Left Arrow
            Image(
                painter = painterResource(R.drawable.baseline_arrow_back_ios_24), // Replace with custom left arrow if needed
                contentDescription = "Left Arrow",

                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 6.dp)
                    .size(32.dp)
            )

            // Right Arrow
            Image(
                painter = painterResource(R.drawable.baseline_arrow_forward_ios_24), // Replace with custom right arrow if needed
                contentDescription = "Right Arrow",

                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 6.dp)
                    .size(32.dp)
            )

            // Text with Transparent Background in the Center
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .align(Alignment.Center)
                    .background(Color.Black.copy(alpha = 0.6f))
                    .padding(16.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Title Text
                Text(
                    text = hostel.hostelname,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )

                // Dotted Line
                Canvas(
                    modifier = Modifier
                        .width(300.dp)
                        .height(10.dp)
                        .padding(vertical = 8.dp)
                ) {
                    drawLine(
                        color = Color.White.copy(alpha = 0.6f),

                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Icons with Text
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ImageWithWhiteText(
                        image = painterResource(id = hostel.hostelimage1), // Replace with your image resource
                        boldText = hostel.boldtext1,
                        normalText = hostel.normaltext1
                    )
                    ImageWithWhiteText(
                        image = painterResource(id = hostel.hostelimage2), // Replace with your image resource
                        boldText = (hostel.boldtext2),

                        normalText = "\na week"
                    )
                    ImageWithWhiteText(
                        image = painterResource(
                            id = hostel.hostelimage3
                        ), // Replace with your image resource
                        boldText = hostel.boldtext3,
                        normalText = hostel.normaltext3
                    )
                }
            }
        }

        Text(
            text = "Key Features",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        // Description
        Text(
            text = hostel.hosteldescription,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp) // Horizontal spacing
        ) {
            items(hostel.featureList.size) { medicine ->
                ImageWithBlackText(
                    imageRes = hostel.featureList[medicine].icon,
                    boldText = hostel.featureList[medicine].title,
                    normalText = hostel.featureList[medicine].caption
                )
            }
        }

        /*
        // Rows of Images and Text
        // Three rows of images with text
        Row(
            modifier = Modifier
                .fillMaxWidth()


                .padding(4.dp),

            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        )
        {
            listOf(
                Pair(hostel.hostelimage4, hostel.boldtext4 to hostel.normaltext4),
                Pair(hostel.hostelimage5, hostel.boldtext5 to hostel.normaltext5),
                Pair(hostel.hostelimage6, hostel.boldtext6 to hostel.normaltext6)
            ).forEach { (image, textPair) ->
                ImageWithBlackText(
                    image = painterResource(id = image),
                    boldText = textPair.first,
                    normalText = textPair.second
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            listOf(
                Pair(hostel.hostelimage7, hostel.boldtext7 to hostel.normaltext7),
                Pair(hostel.hostelimage8, hostel.boldtext8 to hostel.normaltext8),
                Pair(hostel.hostelimage9, hostel.boldtext9 to hostel.normaltext9)
            ).forEach { (image, textPair) ->
                ImageWithBlackText(
                    image = painterResource(id = image),
                    boldText = textPair.first,
                    normalText = textPair.second
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            listOf(
                Pair(hostel.hostelimage10, hostel.boldtext10 to hostel.normaltext10),
                Pair(hostel.hostelimage11, hostel.boldtext11 to hostel.normaltext11),
                Pair(hostel.hostelimage12, hostel.boldtext12 to hostel.normaltext12)
            ).forEach { (image, textPair) ->
                ImageWithBlackText(
                    image = painterResource(id = image),
                    boldText = textPair.first,
                    normalText = textPair.second
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            listOf(
                Pair(hostel.hostelimage13, hostel.boldtext13 to hostel.normaltext13),


            ).forEach { (image, textPair) ->
                ImageWithBlackText(
                    image = painterResource(id = image),
                    boldText = textPair.first,
                    normalText = textPair.second
                )
            }
        }

        */
    }
}


@Composable
fun ImageWithWhiteText(image: Painter, boldText: String, normalText: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Display the image
        Image(
            painter = image,
            contentDescription = null, // Optional, no description needed
            modifier = Modifier
                .size(30.dp)
                .padding(bottom = 8.dp) // Space between image and text
        )

        // Text with mixed styles
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(boldText)
                }
                append(" ") // Add space between bold and normal text
                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                    append(normalText)
                }
            },
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ImageWithBlackText(imageRes: Int, boldText: String, normalText: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 6.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(bottom = 8.dp)

        )
        Text(
            text = boldText,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = normalText,
            style = MaterialTheme.typography.labelMedium,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //  HDetails()
    HostelDetails(SelectHostel.hostel)
}



