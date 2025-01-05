package com.S3246961venkat.hostelmanagment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.database.FirebaseDatabase
import com.S3246961venkat.hostelmanagment.activities.MainHomeActivity


class SignInActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SignInScreen()
        }
    }
}


@Composable
fun SignInScreen() {
    var residentEmail  by remember { mutableStateOf("") }
    var residentCode by remember { mutableStateOf("") }

    val appContext = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.p1)),
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Welcome back!",
                color = colorResource(id = R.color.p2),
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "Please enter your details",
                color = colorResource(id = R.color.p2),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = residentEmail,
                onValueChange = { residentEmail = it },
                label = { Text("Enter E-Mail") },
            )

            Spacer(modifier = Modifier.height(4.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = residentCode,
                onValueChange = { residentCode = it },
                label = { Text("Enter Password") },
            )

            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = {
                    when {
                        residentEmail.isEmpty() -> {
                            Toast.makeText(appContext, "Resident Email is required", Toast.LENGTH_SHORT).show()
                        }

                        residentCode.isEmpty() -> {
                            Toast.makeText(appContext, "Resident Password is required", Toast.LENGTH_SHORT)
                                .show()
                        }

                        else -> {
                            signInGuest(residentEmail, residentCode, appContext)
                        }

                    }
                },
                modifier = Modifier
                    .padding(16.dp, 2.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.p2),
                    contentColor = colorResource(id = R.color.p1)
                )
            ) {
                Text("SignIn")
            }


            Spacer(modifier = Modifier.height(12.dp))

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Don't have an account? ",
                    color = colorResource(id = R.color.p2),
                    style = MaterialTheme.typography.bodyLarge,
                )

                Text(
                    text = "SignUp",
                    color = colorResource(id = R.color.p2),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black),
                    modifier = Modifier.clickable {
                        appContext.startActivity(Intent(appContext, SignUpActivity::class.java))
                        appContext.finish()
                    }
                )

            }

            Spacer(modifier = Modifier.height(36.dp))


        }
    }

}

private fun signInGuest(useremail: String, userpassword: String, appContext: Activity) {
    val firebaseDatabase = FirebaseDatabase.getInstance()
    val databaseReference = firebaseDatabase.getReference("Users").child(useremail.replace(".", ","))

    databaseReference.get().addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val userData = task.result?.getValue(ResidentData::class.java)
            checkAndGO(useremail, userpassword, appContext, userData)
        } else {
            Toast.makeText(
                appContext,
                "Failed to Fetch Details",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

fun checkAndGO(
    useremail: String,
    userpassword: String,
    appContext: Activity,
    userData: ResidentData?
) {
    if (userData != null) {
        if (userData.userpassword == userpassword) {
            Toast.makeText(appContext, "Login successful", Toast.LENGTH_SHORT).show()
            ResidentDetails.saveResidentLoginStatus(appContext, true)
            ResidentDetails.saveResidentEmail(appContext, useremail)
            ResidentDetails.saveResidentName(appContext, userData.username)
            appContext.startActivity(Intent(appContext, MainHomeActivity::class.java))
            appContext.finish()
        } else {
            Toast.makeText(appContext, "Invalid Password", Toast.LENGTH_SHORT).show()
        }
    } else {
        Toast.makeText(appContext, "No user data found", Toast.LENGTH_SHORT).show()
    }
}


@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}
