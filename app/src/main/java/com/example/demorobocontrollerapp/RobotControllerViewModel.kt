package com.example.demorobocontrollerapp

import android.util.StringBuilderPrinter
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

// as good practice, this class define and hold data belong to a robot
class RobotControllerViewModel : ViewModel() {
    // Private mutable state (encapsulated)
    private var _messageOnDisplay = mutableStateOf("Hi, let's lift with ease!")

    // Publicly exposed immutable state
    //val displayText: State<String> get() = _messageOnDisplay
    val displayText: MutableState<String> = _messageOnDisplay

    // Public method to update the display text
    fun setDisplayText(newText: String) {
        _messageOnDisplay.value = newText
    }
}
