package com.example.ejerciciobuttonalvaroguerreroduarte


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejerciciobuttonalvaroguerreroduarte.Botones
import com.example.ejerciciobuttonalvaroguerreroduarte.ui.theme.EjerciciobuttonAlvaroGuerreroDuarteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjerciciobuttonAlvaroGuerreroDuarteTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    /*Text(
        text = "Hello $name!",
        modifier = modifier
    )*/
    Botones()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjerciciobuttonAlvaroGuerreroDuarteTheme() {
        Greeting("Android")
    }
}
