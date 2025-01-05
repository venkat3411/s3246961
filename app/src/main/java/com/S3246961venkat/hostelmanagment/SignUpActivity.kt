package com.S3246961venkat.hostelmanagment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.S3246961venkat.hostelmanagment.ui.theme.HostelManagmentTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HostelManagmentTheme {
                SignUpScreen()
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    var residentName by remember { mutableStateOf("") }
    var residentMail by remember { mutableStateOf("") }
    var residentCode by remember { mutableStateOf("") }
    var confirmResidentPassword by remember { mutableStateOf("") }

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
                text = "Welcome to our App!",
                color = colorResource(id = R.color.p2),
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "Please fill your details",
                color = colorResource(id = R.color.p2),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = residentMail,
                onValueChange = { residentMail = it },
                label = { Text("Enter Mail") },

                )

            Spacer(modifier = Modifier.height(6.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = residentName,
                onValueChange = { residentName = it },
                label = { Text("Enter Name") }
            )

            Spacer(modifier = Modifier.height(6.dp))


            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = residentCode,
                onValueChange = { residentCode = it },
                label = { Text("Enter Password") }
            )


            Spacer(modifier = Modifier.height(6.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = confirmResidentPassword,
                onValueChange = { confirmResidentPassword = it },
                label = { Text("Confirm Password") }
            )

            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = {

                    if (residentName.isEmpty()) {
                        Toast.makeText(appContext, "Resident name is required", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    if (residentMail.isEmpty()) {
                        Toast.makeText(appContext, "Resident Email is required", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    if (residentCode.isEmpty()) {
                        Toast.makeText(appContext, "Resident Password is required", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    if (residentCode != confirmResidentPassword) {
                        Toast.makeText(appContext, "Seems passwords are different", Toast.LENGTH_SHORT)
                            .show()
                        return@Button
                    } else {

                        val residentData = ResidentData(
                            username = residentName,
                            useremail = residentMail,
                            userpassword = residentCode
                        )
                        signUpGuest(residentData, appContext)
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
                Text("SignUp")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Spacer(modifier = Modifier.weight(1f))


            Row(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Already have an account? ",
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorResource(id = R.color.p2),
                )

                Text(
                    text = "SignIn",
                    color = colorResource(id = R.color.p2),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black),
                    modifier = Modifier.clickable {
                        appContext.startActivity(Intent(appContext, SignInActivity::class.java))
                        appContext.finish()
                    }
                )
            }

        }

    }
}

private fun signUpGuest(residentData: ResidentData, appContext: Activity) {
    val firebaseDatabase = FirebaseDatabase.getInstance()
    val databaseReference = firebaseDatabase.getReference("Users")

    databaseReference.child(residentData.useremail.replace(".", ",")).setValue(residentData)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                checkandLogin(appContext)
            } else {
                Toast.makeText(
                    appContext,
                    "Account Creation UnSuccessfull",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        .addOnFailureListener { _ ->
            Toast.makeText(
                appContext,
                "Failure",
                Toast.LENGTH_SHORT
            ).show()
        }
}

fun checkandLogin(appContext: Activity) {
    Toast.makeText(appContext, "Registration Successful", Toast.LENGTH_SHORT).show()
    appContext.startActivity(Intent(appContext, SignInActivity::class.java))
    appContext.finish()
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}