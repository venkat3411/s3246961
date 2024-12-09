package com.venkatS3246961.hostelmanagment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.venkatS3246961.hostelmanagment.activities.MainDashboardActivity
import com.venkatS3246961.hostelmanagment.activities.MainHomeActivity
import com.venkatS3246961.hostelmanagment.ui.theme.HostelManagmentTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HostelManagmentTheme {
                MainScreen(onLoginClick = { value ->})
            }
            }
    }


}

@Composable
fun MainScreen(onLoginClick: (value: Int) -> Unit) {
    var showSplash by remember { mutableStateOf(true) }

    val context = LocalContext.current as Activity

    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds delay
        showSplash = false
    }
    if (showSplash) {
        SplashScreen()
    } else {
        val ResidentStatus = ResidentDetails.getResidentLoginStatus(context)

        if (ResidentStatus) {
            context.startActivity(Intent(context, MainHomeActivity::class.java))
            context.finish()
        }
        else {
            context.startActivity(Intent(context, SignInActivity::class.java))
            context.finish()
        }
    }
}




@Composable
fun SplashScreen() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.p1)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.weight(1f))


            Image(
                painter = painterResource(id = R.drawable.hostel_icon),
                contentDescription = "Book Hostel through Venkat App",
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Book Hostel through",
                color = colorResource(id = R.color.p2),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 6.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Venkat App",
                color = colorResource(id = R.color.p2),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 18.dp)
                    .align(Alignment.CenterHorizontally)
            )


        }
    }

}


@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    SplashScreen()
}
