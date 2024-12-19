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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demorobocontrollerapp.ui.theme.DemoRoboControllerAppTheme
import androidx.compose.ui.platform.LocalContext

const val BorderColor = 0xFF333333 // soft black
const val TextColor = 0xFFF8F8F8 // off-white
const val GripControlColor = 0xFFA3C8F2 // soft blue
const val ElevationControlColor = 0xFFA8D5BA // soft green

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoRoboControllerAppTheme {
        DemoLayout()
    }
}

@Composable
fun DemoLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray), // makes the column take up the full available space
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
                .border(2.dp, Color(BorderColor)) // to simulate a monitor border
                .background(Color(0xFF4B4F54)),
            contentAlignment = Alignment.Center
        ) {
            Text("Monitor",color= Color(TextColor))
        }

        // Grip Control Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            //.background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Spacer(modifier = Modifier.height(16.dp)) // space between
            Column {
                // TODO: Temporarily placed here
                Box(
                    modifier = Modifier
                        .fillMaxWidth() // makes the Box take up the full width of its parent container
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text("Grip Control Section")
                }

                // Grab-Release
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
                                containerColor = Color(GripControlColor), // Button background color (soft green)
                                contentColor = Color(TextColor)
                            ),
                            modifier = Modifier
                                .border(
                                    2.dp,
                                    Color(BorderColor)
                                ) // Border with the same color as the background
                                .clip(CircleShape) // Make the button circular
                        ) {
                            Text("Grab")
                            Icon(Icons.Default.AddCircle, contentDescription = "Grab")
                        }
                    }

                    // 'Release' btn
                    Box {
                        Button(onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(GripControlColor), // Button background color (soft green)
                                contentColor = Color(TextColor)
                            ), modifier = Modifier
                                .border(
                                    2.dp,
                                    Color(BorderColor)
                                ) // Border with the same color as the background
                                .clip(CircleShape) // Make the button circular
                        ) {
                            Text("Release")
                            Icon(Icons.Default.CheckCircle, contentDescription = "Release")
                        }
                    }
                }

                // TODO: Elevation Control Section
                Box(
                    modifier = Modifier
                        .fillMaxWidth() // makes the Box take up the full width of its parent container
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text("Elevation Control Section")
                }

                // Lift-Lower
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    // 'Lift' btn
                    Box {
                        Button(onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(ElevationControlColor), // button background color (purple)
                                contentColor = Color.White // Text color (white)
                            ), modifier = Modifier
                                .border(
                                    2.dp,
                                    Color(BorderColor)
                                ) // border with the same color as the background
                                .clip(CircleShape) // Make the button circular
                        ){
                            Text("Lift")
                            Icon(
                                Icons.Default.KeyboardArrowUp,
                                contentDescription = "Lift")
                        }
                    }

                    // 'Lower' btn
                    Box {
                        Button(onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(ElevationControlColor), // button background color (soft green)
                                contentColor = Color(TextColor)
                            ), modifier = Modifier
                                .border(
                                    2.dp, Color(BorderColor)
                                ) // border with the same color as the background
                                .clip(CircleShape) // Make the button circular
                        ) {
                            Text("Lower")
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = "Lower"
                            )
                        }
                    }

                }
            }
        }

        // Directional Control button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            //.background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(), // makes the Row take up the full width of its parent container
                horizontalArrangement = Arrangement.SpaceEvenly, // evenly space out the two Box elements
                verticalAlignment = Alignment.CenterVertically // center the content vertically within the Row
            ) {
                // Directional console
                Box(
                    modifier = Modifier
                        .size(100.dp), // assign a fixed size to the Box (adjusted from 'fillMaxWidth')
                    contentAlignment = Alignment.Center // center the content (Text) inside the Box
                ) {
                    Text("Directional Control")
                    // TODO: Practice how to make console button then apply here
                    //GameConsole()
                }
            }
        }
    }
}

// TODO: Migrate 'Monitor' code here
//@Composable
//fun ShowMonitor(){
//}

// TODO: Migrate 'Grip Control' here
//@Composable
//fun ShowGripControl(){
//}

// TODO: Migrate 'Elevation Control' here
//@Composable
//fun ShowElevationControl(){
//}

// TODO: Update layout & positioning
// Composable function for the game console (buttons)
@Composable
fun GameConsole() {
    // Accessing the context within a composable function
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()  // Make the column fill the screen
            .wrapContentSize(Alignment.Center)  // Center the column within the screen
    ) {
        // Row for the first set of buttons (left, up, right)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DirectionalButton("←") {
                // Show toast when left button is pressed
                Toast.makeText(context, "Left pressed", Toast.LENGTH_SHORT).show()
            }
            DirectionalButton("↑") {
                // Show toast when up button is pressed
                Toast.makeText(context, "Up pressed", Toast.LENGTH_SHORT).show()
            }
            DirectionalButton("→") {
                // Show toast when right button is pressed
                Toast.makeText(context, "Right pressed", Toast.LENGTH_SHORT).show()
            }
        }

        // Row for the second set of buttons (left, down, right)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DirectionalButton("←") {
                // Show toast when left button is pressed
                Toast.makeText(context, "Left pressed", Toast.LENGTH_SHORT).show()
            }
            DirectionalButton("↓") {
                // Show toast when down button is pressed
                Toast.makeText(context, "Down pressed", Toast.LENGTH_SHORT).show()
            }
            DirectionalButton("→") {
                // Show toast when right button is pressed
                Toast.makeText(context, "Right pressed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

// A composable function for the directional buttons (left, right, up, down)
@Composable
fun DirectionalButton(direction: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,  // Action to be performed when the button is clicked
        modifier = Modifier
            .padding(10.dp)  // Add some space around each button
            .width(80.dp)  // Set width of each button
            .height(80.dp)  // Set height of each button
            .background(Color(0xFF6200EE)),  // Set a purple background color
    ) {
        // Correct usage of Text composable, passing a String (direction) parameter
        Text(
            text = direction,  // The text on each button (like "←", "↑", "→", "↓")
            color = Color.White,  // Set the text color to white
        )
    }
}