package za.ac.cput.myjourney

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import kotlin.system.exitProcess

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
        composable("modules", content= { ScreenThree(navController = navController)})

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

        //Current modules button to third screen
        val openDialog = remember { mutableStateOf(false) }

        Button(onClick = {
            openDialog.value = true
            navController.navigate("modules")
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

//Screen 3
@Composable
fun ScreenThree(navController: NavController) {

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {

        Text(
            text = "List of my Current Modules",
            style = TextStyle(textDecoration = TextDecoration.Underline),
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    Row() {
        Text(text = " Applications Development Practice 3 \nPractical Subject --- Year Round Module " +
                "\n\n Applications Development Theory 3 \n Theory Subject --- Year Round Module " +
                "\n\n ICT Electives 3 \n Practical Subject --- Semester One Module " +
                "\n\n Information Systems 3 \n Practical and Theory Subject --- Year Round Module " +
                "\n\n Project 3 \n Practical Subject --- Year Round Module " +
                "\n\n Project Management 3 \n Theory Subject --- Semester One Module " +
                "\n\n Professional Practice 3 \n Theory Subject --- Semester One Module " +
                "\n\n Project Presentation 3 \n Practical Subject --- Year Round Module \n\n",
            fontSize = 15.sp)
    }
//Goodbye Button
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(5.dp, 5.dp)) {
            val openDialog = remember { mutableStateOf(false)  }
            val activity = (LocalContext.current as? Activity)

            Button(onClick = {
                openDialog.value = true
                PaddingValues(20.dp)
            })

            {
                Text("Goodbye")

                Icon (
                    Icons.Filled.ExitToApp,
                    contentDescription = "Goodbye Button",
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.size(20.dp)
                )
            }

            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Are you sure you want to exit?")
                    },
                    text = {
                        Text("Leaving Now?")
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("No")
                        }
                    },
                    dismissButton ={
                       Button(
                           onClick = {
                               openDialog.value = false
                               activity?.finish()  //Exits Application

                       }) {
                           Text(text = "Yes")
                       }

                    }

                    )
            }
        }

        Row(verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            ) {

            val openDialog = remember { mutableStateOf(false) }

            Button(onClick = {
                openDialog.value = true
                navController.navigate("journey")
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

        }

    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyJourneyTheme {

        ScreenNav()
    }
}