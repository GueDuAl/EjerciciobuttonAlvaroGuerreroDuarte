package com.example.ejerciciobuttonalvaroguerreroduarte

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable

@Composable
fun ClaseSwitch(switchChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Switch(checked = switchChecked, onCheckedChange = onCheckedChange)
}

