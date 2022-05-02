package za.ac.cput.myjourney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import za.ac.cput.myjourney.ui.theme.MyJourneyTheme
import za.ac.cput.myjourney.ui.theme.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJourneyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {
                }
                Column (verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()) {
                    ScreenNav()
                }

            }
        }
    }
}

@Composable
fun ScreenNav() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome", builder = {
        composable("welcome", content= { ScreenMain(navController = navController)})
        composable("journey", content= { ScreenTwo(navController = navController)})

    } )

}

@Composable
fun ScreenMain(navController: NavController) {

    Column (verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {

        //Welcome text
        Text(text = "Welcome to my Jetpack Compose Journey",
            fontSize = 30.sp,
            textAlign = TextAlign.Center)
        //Alert Button
        MyJourneyTheme() {
            Column {
                val openDialog = remember { mutableStateOf(false)  }

                Button(onClick = {
                    openDialog.value = true
                })

                {
                    Text("Info")

                    Icon (
                        Icons.Filled.Info,
                        contentDescription = "Refresh Button",
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }

                if (openDialog.value) {

                    AlertDialog(
                        onDismissRequest = {
                            // Dismiss the dialog when the user clicks outside the dialog or on the back
                            // button. If you want to disable that functionality, simply use an empty
                            // onCloseRequest.
                            openDialog.value = false
                        },
                        title = {
                            Text(text = "Hi, this is My Journey")
                        },
                        text = {
                            Text("I have really been enjoying my Mobile development journey, I always look forward to the next class and for what is ahead")
                        },
                        confirmButton = {
                            Button(

                                onClick = {
                                    openDialog.value = false
                                }) {
                                Text("Exit")
                            }
                        },

                        )
                }
            }

        }
        MyJourneyTheme() {
            Column {
                val openDialog = remember { mutableStateOf(false) }

                Button(onClick = {
                    openDialog.value = true
                    navController.navigate("journey")
                })

                {
                    Text("Start Journey")

                    Icon(
                        Icons.Filled.ArrowForward,
                        contentDescription = "Start Button",
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }

            }
        }
    }

}
//Start Journey Button Leads to next page

@Composable
fun ScreenTwo(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        //Heading
        Text(
            text = "Student Details",
            style = TextStyle(textDecoration = TextDecoration.Underline),
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        //Details about Me
        Text(
            text = "Name: Moegamad Nur Duncan \n\nCourse: Diploma in Information Technology\n\nDepartment: Applications Development\n\nStudent Number: 220014442",
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )

        //Dummy Button
        val openDialog = remember { mutableStateOf(false) }

        Button(onClick = {
            openDialog.value = true
        })

        {
            Text("Current Modules")

            Icon(
                Icons.Filled.AccountBox,
                contentDescription = "Current Button",
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier.size(20.dp)
            )
        }
    }
            //Back Button

            val openDialog = remember { mutableStateOf(false) }

            Button(onClick = {
                openDialog.value = true
                navController.navigate("welcome")
            })

            {
                Text("Back")

                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Back Button",
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.size(20.dp)
                )
            }

        }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyJourneyTheme {

        ScreenNav()
    }
}