package com.example.ejerciciobuttonalvaroguerreroduarte

import android.os.CountDownTimer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.ejerciciobuttonalvaroguerreroduarte.R

@Composable
fun Botones() {
    var buttonText by remember { mutableStateOf("Presionar") }
    var selectedImage by remember { mutableStateOf(0) }
    var showText by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }
    var switchChecked by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }
    var showProgress by remember { mutableStateOf(false) }


    val images = listOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Icon(Icons.Default.Star, contentDescription = "Star Icon", modifier = Modifier.size(50.dp))


        ClaseSwitch(switchChecked = switchChecked) { switchChecked = it }


        if (switchChecked) {
            RadioButtonGroup(
                options = listOf("Opción 1", "Opción 2", "Opción 3"),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                    buttonText = "Seleccionaste: $option"
                }
            )
        }


        CustomButton(buttonText = buttonText) {
            buttonText = "Botón presionado"
            showProgress = true
            selectedImage = (selectedImage + 1) % images.size


            object : CountDownTimer(5000, 1000) {
                override fun onTick(millisUntilFinished: Long) {}
                override fun onFinish() {
                    buttonText = "Presionar"
                    showProgress = false
                }
            }.start()
        }


        if (showProgress) {
            CircularProgressIndicator(modifier = Modifier.padding(vertical = 16.dp))
        }


        Checkbox(checked = isChecked, onCheckedChange = {
            isChecked = it
            showText = it
        })
        Text("Activar texto")


        if (showText) {
            Text("Texto activado por el checkbox")
        }


        Image(
            painter = rememberImagePainter(data = images[selectedImage]),
            contentDescription = "Imagen dinámica",
            modifier = Modifier.size(150.dp)
        )
    }
}
