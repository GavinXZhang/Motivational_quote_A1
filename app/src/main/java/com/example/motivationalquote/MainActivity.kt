package com.example.motivationalquote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivationalquote.ui.theme.MotivationalQuoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MotivationalQuoteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MotivationalQuoteScreen(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun MotivationalQuoteScreen(modifier: Modifier = Modifier) {
    val quotes = listOf(
        "Believe you can and you're half way there",
        "Don't watch to clock; do what it does, keep going!",
        "Success is not final, failure is not fatal: It is the courage to continue that counts",
        "Don't stop when you're tired, Stop when you're done",
        "The only limit to our realization of tomorrow is our doubts of today"
    )
    var currentQuote by remember {mutableStateOf(quotes.random())}

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment =  Alignment.Center
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = currentQuote,
                fontSize = 24.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center

            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { currentQuote = quotes.random()}) {
                Text(text = "New Quote")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MotivationalQuoteTheme {
        MotivationalQuoteScreen()
    }
}