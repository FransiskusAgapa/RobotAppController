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


const val MonitorBgColor = 0xFF4B4F54// smoke gray
const val MonitorBorderColor = 0xFF333333 // soft black
//const val TextColor = 0xFFF8F8F8 // off-white
const val TextColor = 0xFF212529 // dark gray
const val ManipulatorBtnColor = 0xFF3498DB  // sky blue
const val ElevationBtnColor = 0xFF1ABC9C // soft green
const val NavigationBtnColor = 0xFFD3D3D3 // light gray
val FontSize = 20.sp // better readability
val ButtonWidth = 150.dp
val ButtonHeight = 50.dp

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
                ShowMonitor(displayText = "")
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
                ShowNavPanel()
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
            Text(displayText, color = Color(TextColor))
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
                        containerColor = Color(ManipulatorBtnColor), // Button background color (soft green)
                        contentColor = Color(TextColor)
                    ),
                    modifier = Modifier
                        .border(2.dp, Color(ManipulatorBtnColor)) // border color
                        .clip(CircleShape) // Make the button circular
                        .width(ButtonWidth)
                        .height(ButtonHeight)
                ) {
                    Text("Grab ",fontSize = FontSize, fontWeight = FontWeight.Bold)
                    Icon(Icons.Default.AddCircle, contentDescription = "Grab")
                }
            }

            // 'Release' btn
            Box {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(ManipulatorBtnColor), // Button background color (soft green)
                        contentColor = Color(TextColor)
                    ), modifier = Modifier
                        .border(2.dp, Color(ManipulatorBtnColor)) // Border color
                        .clip(CircleShape) // Make the button circular
                        .width(ButtonWidth)
                        .height(ButtonHeight)
                ) {
                    Text("Release ",fontSize = FontSize, fontWeight = FontWeight.Bold)
                    Icon(Icons.Default.CheckCircle, contentDescription = "Release")
                }
            }
        }
}

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
                        containerColor = Color(ElevationBtnColor), // button background color (purple)
                        contentColor = Color(TextColor) // Text color (white)
                    ), modifier = Modifier
                        .border(
                            2.dp,
                            Color(ElevationBtnColor)
                        ) // border with the same color as the background
                        .clip(CircleShape) // Make the button circular
                        .width(ButtonWidth)
                        .height(ButtonHeight)
//                        .fillMaxWidth() // takes space too much
                ) {
                    Text("Lift ",fontSize = FontSize, fontWeight = FontWeight.Bold)
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
                        containerColor = Color(ElevationBtnColor), // button background color (soft green)
                        contentColor = Color(TextColor)
                    ), modifier = Modifier
                        .border(2.dp, Color(ElevationBtnColor)) // border color
                        .clip(CircleShape) // Make the button circular
                        .width(150.dp)
                        .height(50.dp)
//                        .fillMaxWidth()
                ) {
                    Text("Lower ",fontSize = FontSize, fontWeight = FontWeight.Bold)
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = "Lower"
                    )
                }
            }
        }
    }
}

// TODO: figure out how text can be display into monitor when btn pressed
@Composable // show 'Navigation' panel ('Left','Top','Bottom','Right')
fun ShowNavPanel(){
    // state to hold value to be display
    var displayText by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = displayText)
    }
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ){
        // 'left' btn
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center // center content
        ){
            Button(
                onClick = {
                    displayText = "LEFT Button Clicked"
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(NavigationBtnColor), // button background color (soft green)
                    contentColor = Color(TextColor)
                ),
                modifier = Modifier
                    .width(ButtonWidth)
                    .height(ButtonHeight)
                    .padding(1.dp),
            ) {
                Text("← Left",fontSize = FontSize, fontWeight = FontWeight.Bold)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.2f),
            contentAlignment = Alignment.Center
        ){
            // TODO: Stack 'Top' before 'Bottom' btn
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            ){
                Button(onClick = {
                    displayText = "TOP Button Clicked"
                },
                    modifier = Modifier
                        .width(ButtonWidth)
                        .height(ButtonHeight),
                    colors = ButtonDefaults.buttonColors(
                        // set button and its text color
                        Color(NavigationBtnColor), // bg Color
                        Color(TextColor) // txt Color
                    )
                ){
                    Text("Top ↑",fontSize = FontSize, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(46.dp))
                Button(onClick = {
                    displayText = "BOTTOM Button Clicked"
                },
                    modifier = Modifier
                        .width(ButtonWidth)
                        .height(ButtonHeight),
                    colors = ButtonDefaults.buttonColors(
                        // set button and its text color
                        Color(NavigationBtnColor), // bg Color
                        Color(TextColor) // txt Color
                    )
                ){
                    Text("Bottom ↓",fontSize = FontSize, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // space between

        // TODO: add 'right' btn & color
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ){
            Button(onClick = {
                displayText = "RIGHT Button Clicked"
            },
                modifier = Modifier
                    .width(ButtonWidth)
                    .height(ButtonHeight)
                    .padding(1.dp),
                colors = ButtonDefaults.buttonColors(
                    // set button and its text color
                    Color(NavigationBtnColor), // bg Color
                    Color(TextColor) // txt Color
                )
            ){
                Text("Right →",fontSize = FontSize, fontWeight = FontWeight.Bold)
            }
        }
    }
}


// UI Standards
// font size - readability: 20.sp
// font weight - clarity: FontWeight.Bold
// btn height - minimum target size: height(48.dp)
// padding - spacing/usability: 16.dp