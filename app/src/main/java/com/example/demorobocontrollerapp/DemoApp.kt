package com.example.demorobocontrollerapp

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demorobocontrollerapp.ui.theme.DemoRoboControllerAppTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalConfiguration

// General setting
const val TextColor = 0xFF212529 // dark gray // OxFF000000

// Monitor setting
val MonitorFontSize = 32.sp
const val MonitorBgColor = 0xFF212121 //-> dark gray
const val MonitorTextColor = 0xFFF8F8F8 // off-white

// Manipulation & Elevation setting
const val ManipBtnColor = 0xFF007BFF// 0xFF3498DB  // sky blue
const val ElevBtnColor = 0xFF1ABC9C // soft green
val ManipElevFontSize = 21.sp // readability
val ManipElevButtonWidth = 160.dp
val ManipElevButtonHeight = 50.dp

// Navigation setting
val NavFontSize = 21.sp // 'nav' = 'navigation'
const val NavBtnColor = 0xFFD3D3D3 // light gray
val ForBacButtonWidth = 200.dp // 'Forward' , 'Backward' btn's width
val LefRigButtonWidth = 300.dp // 'Left' , 'Right' btn's width
val NavButtonHeight = 50.dp

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoRoboControllerAppTheme {
        DisplayApp()
    }
}

@Composable // the whole app display
fun DisplayApp() {
    val configuration = LocalConfiguration.current // check view mode
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    val displayText = remember { mutableStateOf("Hi, Let's Lift With Ease") }
    Column(
        modifier = Modifier.fillMaxSize() // use the whole screen size
    ) {
        //TODO: Finish 'landscape' view design
        if (isLandscape) { // 'Landscape' view mode
            //Monitor
            Column(
                modifier = Modifier
                    .fillMaxWidth() // use allocated space as much as possible
                    .weight(0.5f) // take portion of the space vertically - increase/decrease as needed
            ){
                ShowMonitor(displayText.value) // .value makes it a string
            }

            // Manipulation, Navigation,  Elevation
            Column(
                modifier = Modifier
                    .fillMaxWidth() // use allocated space as much as possible
                    .weight(1.4f) // take portion of the space vertically - increase/decrease as needed
            ){
                //Manipulation
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                )
                {
                    Grab(displayText)
                    Release(displayText)
                }

                //Elevation
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                )
                {
                    Lift(displayText)
                    Lower(displayText)
                }

                //Navigation
                // - 'Forward' btn
                Column(modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.8f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Forward(displayText, isLandscape)
                }

                // - 'Left' & 'Right'
                Column(modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.8f)
                        ){
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Left(displayText, isLandscape)
                                Right(displayText, isLandscape)
                            }
                        }

                // - 'Backward' btn
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Backward(displayText, isLandscape)
                }
            } // after this is 'Portrait' view
        } else { // 'Portrait' view mode
            // 'Monitor' section
            Column(
                modifier = Modifier
                    .fillMaxWidth() // use allocated space as much as possible
                    .weight(0.7f) // take portion of the space vertically - increase/decrease as needed
            ) {
                Box(contentAlignment = Alignment.Center) {
                    ShowMonitor(displayText.value) // .value makes it a string
                }
            }

            // 'Manipulation' section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Grab(displayText)
                    Spacer(modifier = Modifier.width(32.dp)) // add spacing between buttons
                    Release(displayText)
                }
            }

            // 'Elevation' section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Lift(displayText)
                    Spacer(modifier = Modifier.width(32.dp)) // add spacing between buttons
                    Lower(displayText)
                }
            }

            // 'Navigation' section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.2f)
            ) {
                //TODO: change this to separate btn call
                ShowNavPanel(displayText) // 'displayText' is the 'mutableState<String>'
            }
        }
    }
}

// Monitor
@Composable
fun ShowMonitor(displayText: String){ //
    Column(
        // background
        modifier = Modifier
            .fillMaxSize()
            .background(Color(MonitorBgColor)), // makes the column take up the full available space
        verticalArrangement = Arrangement.SpaceEvenly, // evenly spaces the header, main, and footer
        horizontalAlignment = Alignment.CenterHorizontally // centers horizontally (optional)
    ) {
        // Monitor
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // assign how much space vertically
                .height(100.dp) // sets the height of the Box to 200dp
                .padding(16.dp) // adds padding around the Box (inside space)
                .border(2.dp, Color(MonitorBgColor)) // to simulate a monitor border
                .background(Color(MonitorBgColor)),
            contentAlignment = Alignment.Center // center content
        ) {
            Text(displayText, fontSize = MonitorFontSize ,
                color = Color(MonitorTextColor),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center) // center text horizontally & vertically
            )
        }
    }
}

// Manipulation
@Composable
fun Grab(displayText: MutableState<String>) { // 'Grab'
    Button(
        onClick = { displayText.value = "Grabbing Item..." },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(ManipBtnColor), // button background color (soft green)
            contentColor = Color(TextColor)
        ),
        modifier = Modifier
            .clip(CircleShape) // make the button circular
            .width(ManipElevButtonWidth)
            .height(ManipElevButtonHeight)
    ) {
        Text("Grab ",fontSize = ManipElevFontSize, fontWeight = FontWeight.Bold)
        Icon(Icons.Default.AddCircle, contentDescription = "Grab")
    }
}

@Composable
fun Release(displayText: MutableState<String>){ // 'Release'
    // 'Release' btn
    Button(
        onClick = { displayText.value = "Releasing Item..." },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(ManipBtnColor), // button background color (soft green)
            contentColor = Color(TextColor)
        ), modifier = Modifier
            .clip(CircleShape) // make the button circular
            .width(ManipElevButtonWidth)
            .height(ManipElevButtonHeight)
    ) {
        Text("Release ",fontSize = ManipElevFontSize, fontWeight = FontWeight.Bold)
        Icon(Icons.Default.CheckCircle, contentDescription = "Release")
    }
}

// Elevation
@Composable
fun Lift(displayText: MutableState<String>) { // 'Lift' btn
    Button(
        onClick = { displayText.value = "Lifting Item..." },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(ElevBtnColor), // button background color (purple)
            contentColor = Color(TextColor) // text color (white)
        ), modifier = Modifier
            .clip(CircleShape) // make the button circular
            .width(ManipElevButtonWidth)
            .height(ManipElevButtonHeight)
    ) {
        Text("Lift ",fontSize = ManipElevFontSize, fontWeight = FontWeight.Bold)
        Icon(
            Icons.Default.KeyboardArrowUp,
            contentDescription = "Lift"
        )
    }
}

@Composable
fun Lower(displayText: MutableState<String>){
    Button(
        onClick = { displayText.value = "Lowering Item..." },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(ElevBtnColor), // button background color (soft green)
            contentColor = Color(TextColor)
        ), modifier = Modifier
            .clip(CircleShape) // Make the button circular
            .width(ManipElevButtonWidth)
            .height(ManipElevButtonHeight)
    ) {
        Text("Lower ",fontSize = ManipElevFontSize, fontWeight = FontWeight.Bold)
        Icon(
            Icons.Default.KeyboardArrowDown,
            contentDescription = "Lower"
        )
    }
}

// Navigation
@Composable
fun ShowNavPanel(displayText: MutableState<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.SpaceEvenly, // Distribute buttons evenly vertically
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 'Forward' button
        Button(
            onClick = {
                displayText.value = "Moving Forward..."
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(NavBtnColor),
                contentColor = Color(TextColor)
            ),
            modifier = Modifier
                .fillMaxWidth(0.4f) // Take 40% of the screen width for landscape view, 20% for portrait
                .height(NavButtonHeight)
                .width(ForBacButtonWidth)
        ) {
            Text("Forward ↑",
                fontSize = NavFontSize,
                fontWeight = FontWeight.Bold)
        }

        // 'Left' & 'Right' buttons
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween , // distribute buttons evenly horizontally
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 'Left' button
            Button(
                onClick = {
                    displayText.value = "Moving Left..."
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(NavBtnColor),
                    contentColor = Color(TextColor)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.37f)
                    .height(NavButtonHeight)
            ) {
                Text("← Left",
                    fontSize = NavFontSize,
                    fontWeight = FontWeight.Bold)
            }

            // 'Right' button
            Button(
                onClick = {
                    displayText.value = "Moving Right..."
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(NavBtnColor),
                    contentColor = Color(TextColor)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(NavButtonHeight)
            ) {
                Text("Right →",
                    fontSize = NavFontSize,
                    fontWeight = FontWeight.Bold)
            }
        }

        // 'Backward' button
        Button(
            onClick = {
                displayText.value = "Moving Backward..."
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(NavBtnColor),
                contentColor = Color(TextColor)
            ),
            modifier = Modifier
                .fillMaxWidth(0.42f) // percentage % of the screen width
                .height(NavButtonHeight)
                .width(ForBacButtonWidth)
        ) {
            Text("Backward ↓",
                fontSize = NavFontSize,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun Forward(displayText: MutableState<String>,isLandscape : Boolean) {
        Button(
            onClick = {
                displayText.value = "Moving Forward..."
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(NavBtnColor),
                contentColor = Color(TextColor)
            ),
            modifier = Modifier
                .fillMaxWidth(0.2f) // Take 20% of the screen width for landscape view
                .height(ManipElevButtonHeight)
                .width(ManipElevButtonWidth)
        ) {
            Text("Forward ↑",
                fontSize = NavFontSize,
                fontWeight = FontWeight.Bold)
        }
}

@Composable
fun Backward(displayText: MutableState<String>, isLandscape: Boolean){
        Button(
            onClick = {
                displayText.value = "Moving Backward..."
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(NavBtnColor),
                contentColor = Color(TextColor)
            ),
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .height(ManipElevButtonHeight)
                .width(ManipElevButtonWidth)
        ) {
            Text("Backward ↓",
                fontSize = NavFontSize,
                fontWeight = FontWeight.Bold)
        }
}

@Composable
fun Left(displayText: MutableState<String>, isLandscape: Boolean){
        Button(
            onClick = {
                displayText.value = "Moving Left..."
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(NavBtnColor),
                contentColor = Color(TextColor)
            ),
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .height(ManipElevButtonHeight)
                .width(ManipElevButtonWidth)
        ) {
            Text("← Left",
                fontSize = NavFontSize,
                fontWeight = FontWeight.Bold)
        }
}

@Composable
fun Right(displayText: MutableState<String>, isLandscape: Boolean){
        Button(
            onClick = {
                displayText.value = "Moving Right..."
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(NavBtnColor),
                contentColor = Color(TextColor)
            ),
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .height(ManipElevButtonHeight)
                .width(ManipElevButtonWidth)
        ) {
            Text("Right →",
                fontSize = NavFontSize,
                fontWeight = FontWeight.Bold)
        }
}