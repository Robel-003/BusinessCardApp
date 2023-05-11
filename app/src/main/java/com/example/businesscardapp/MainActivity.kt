package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    businessCard(name = "Robel Hailu", title = "Student", phone = "206-555-1234",
                        email = "hailurobel26@gmail.com",
                        social = "https://www.linkedin.com/in/robelhailu/")
                }
            }
        }
    }
}


@Composable
fun businessCard(name: String, title: String, phone: String,
                 email: String, social: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    )
    {
        personalInfo(name, title)
        Spacer(Modifier.height(100.dp))
        contact(
            phone = phone,
            social = social,
            email = email
        )
    }
}


@Composable
fun personalInfo(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(bottom = 4.dp, start = 8.dp, end = 8.dp)

    ) {
        Spacer(modifier = Modifier.height(300.dp))
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(text = name,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(text = title,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}



@Composable
fun contact(phone: String, social: String,
            email: String, modifier: Modifier = Modifier) {

    Column (
        verticalArrangement = Arrangement.Center
    ) {

        // email section
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.padding(4.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.baseline_email_24),
                contentDescription = "email",
                modifier = modifier.padding(end = 8.dp)
            )
            Text(
                text = email,
                fontSize = 11.sp,
                modifier = modifier.align(Alignment.CenterVertically)
            )
        }

        // phone section
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.padding(4.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.local_phone_24),
                contentDescription = "phone",
                modifier = modifier.padding(end = 8.dp)
            )
            Text(
                text = phone,
                fontSize = 11.sp,
                modifier = modifier.align(Alignment.CenterVertically)
            )
        }

        // social section
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .padding(4.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.alternate_email_24),
                contentDescription = "social",
                modifier = modifier
                    .padding(end = 8.dp)
            )
            Text(
                text = social,
                fontSize = 11.sp,
                modifier = modifier
                    .align(Alignment.CenterVertically)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        businessCard(name = "Robel Hailu", title = "Student", phone = "206-555-1234",
            email = "hailurobel26@gmail.com", social = "https://www.linkedin.com/in/robelhailu/")
    }
}