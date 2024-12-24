package com.example.demorobocontrollerapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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

val MonitorFontSize = 32.sp
const val MonitorBgColor = 0xFF212121 //-> dark gray
//const val MonitorBorderColor = 0xFF333333 // soft black
const val MonitorTextColor = 0xFFF8F8F8 // off-white
const val TextColor = 0xFF212529 // dark gray // OxFF000000
const val ManipBtnColor = 0xFF007BFF// 0xFF3498DB  // sky blue
const val ElevBtnColor = 0xFF1ABC9C // soft green
val ManipElevFontSize = 21.sp // readability
val ManipElevButtonWidth = 160.dp
val ManipElevButtonHeight = 50.dp
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
    //
    val displayText = remember { mutableStateOf("Welcome!\nCommand Your Lifter With Ease") }
    Column(
        modifier = Modifier.fillMaxSize() // use the whole screen size
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth() // use allocated space as much as possible
                .weight(1f) // take 1/3 of the vertical space
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                ShowMonitor(displayText.value) // .value makes it a string
            }
        }

        // 'Manipulation' & 'Elevation' column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            // 'Manipulation
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                ShowManipConsole()
            }
            // 'Elevation'
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                ShowElevPanel()
            }
        }

        //
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                ShowNavPanel(displayText) // 'displayText' is the 'mutableState<String>'
            }
        }
    }
}

@Composable
fun ShowMonitor(displayText: String){
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
                .height(200.dp) // sets the height of the Box to 200dp
                .padding(16.dp) // adds padding around the Box (inside space)
                .border(2.dp, Color(MonitorBgColor)) // to simulate a monitor border
                .background(Color(MonitorBgColor)),
            contentAlignment = Alignment.Center // center content
        ) {
            Text(displayText, fontSize = MonitorFontSize ,color = Color(MonitorTextColor), fontWeight = FontWeight.Bold)
        }
    }
}

@Composable // Show 'Manipulator' console ('Grab' and 'Release')
fun ShowManipConsole(){
//    Column{
//        Box(
//            modifier = Modifier
//                .fillMaxWidth() // makes the Box take up the full width of its parent container
//                .padding(16.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Text("Grip Control Section")
//        }

        Row(
            modifier =
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // ensures the buttons are spaced evenly){
        ) {
            // 'Grab' btn
            Box {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(ManipBtnColor), // Button background color (soft green)
                        contentColor = Color(TextColor)
                    ),
                    modifier = Modifier
                        .clip(CircleShape) // Make the button circular
                        .width(ManipElevButtonWidth)
                        .height(ManipElevButtonHeight)
                ) {
                    Text("Grab ",fontSize = ManipElevFontSize, fontWeight = FontWeight.Bold)
                    Icon(Icons.Default.AddCircle, contentDescription = "Grab")
                }
            }

            // 'Release' btn
            Box {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(ManipBtnColor), // Button background color (soft green)
                        contentColor = Color(TextColor)
                    ), modifier = Modifier
                        .clip(CircleShape) // Make the button circular
                        .width(ManipElevButtonWidth)
                        .height(ManipElevButtonHeight)
                ) {
                    Text("Release ",fontSize = ManipElevFontSize, fontWeight = FontWeight.Bold)
                    Icon(Icons.Default.CheckCircle, contentDescription = "Release")
                }
            }
        }
}

// TODO: Make button bigger then make button text bigger
@Composable // show 'Elevation' panel ('Lift' and 'Lower')
fun ShowElevPanel(){
    Column{
//        Box(
//            modifier = Modifier
//                .fillMaxWidth() // makes the Box take up the full width of its parent container
//                .padding(16.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Text("Elevation Control Section")
//        }

        // Lift-Lower
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // 'Lift' btn
            Box {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(ElevBtnColor), // button background color (purple)
                        contentColor = Color(TextColor) // Text color (white)
                    ), modifier = Modifier
                        .clip(CircleShape) // Make the button circular
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

            // 'Lower' btn
            Box {
                Button(
                    onClick = { /*TODO*/ },
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
        }
    }
}

@Composable
fun ShowNavPanel(displayText: MutableState<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly, // Distribute buttons evenly vertically
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 'Forward' button
        Button(
            onClick = {
                displayText.value = "Move Forward"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(NavBtnColor),
                contentColor = Color(TextColor)
            ),
            modifier = Modifier
                .fillMaxWidth(0.4f) // Take 50% of the screen width
                .height(NavButtonHeight)
                .width(ForBacButtonWidth)
        ) {
            Text("Forward ↑", fontSize = NavFontSize, fontWeight = FontWeight.Bold)
        }

        // 'Left' & 'Right' buttons
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, // Distribute buttons evenly horizontally
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 'Left' button
            Button(
                onClick = {
                    displayText.value = "Move To The Left"
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(NavBtnColor),
                    contentColor = Color(TextColor)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.37f)
                    .height(NavButtonHeight)
                    //.width(LefRigButtonWidth)
            ) {
                Text("← Left", fontSize = NavFontSize, fontWeight = FontWeight.Bold)
            }

            // 'Right' button
            Button(
                onClick = {
                    displayText.value = "Move To The Right"
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(NavBtnColor),
                    contentColor = Color(TextColor)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(NavButtonHeight)
                    //.width(LefRigButtonWidth)
            ) {
                Text("Right →", fontSize = NavFontSize, fontWeight = FontWeight.Bold)
            }
        }

        // 'Backward' button
        Button(
            onClick = {
                displayText.value = "Move Backward"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(NavBtnColor),
                contentColor = Color(TextColor)
            ),
            modifier = Modifier
                .fillMaxWidth(0.4f) // Take 50% of the screen width
                .height(NavButtonHeight)
                .width(ForBacButtonWidth)
        ) {
            Text("Backward ↓", fontSize = NavFontSize, fontWeight = FontWeight.Bold)
        }
    }
}


// UI Standards
// font size - readability: 20.sp
// font weight - clarity: FontWeight.Bold
// btn height - minimum target size: height(48.dp)
// padding - spacing/usability: 16.dp