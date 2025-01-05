package com.S3246961venkat.hostelmanagment.activities

import android.app.Activity
import android.content.Intent
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
import androidx.compose.material3.Button
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
import com.S3246961venkat.hostelmanagment.R

class HostelDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HostelDetails(SelectHostel.hostel)
        }
    }
}


@Composable
fun HostelDetails(hostel: HostelData) {
    val appContext = LocalContext.current as Activity
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
                        appContext.finish()


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

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                val intent = Intent(appContext, BookingActivity::class.java)
                appContext.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Book Now", style = MaterialTheme.typography.bodyMedium, color = Color.White)
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

    }
}


@Composable
fun ImageWithWhiteText(image: Painter, boldText: String, normalText: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(bottom = 8.dp)
        )

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
fun HostelDetailsPreview() {
    HostelDetails(SelectHostel.hostel)
}



