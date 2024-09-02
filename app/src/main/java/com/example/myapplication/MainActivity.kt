package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                GreetingImage(
                    name = "Ali",
                    from = "Mohsen"
                )
            }
        }
    }
}

@Composable
fun GreetingImage(name: String, from : String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty);
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        );
        Greeting(
            name = name,
            from = from,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun GreetingImagePreview() {
    GreetingImage("Ali", from = "Mohsen", Modifier.fillMaxSize())
}

@Composable
fun Greeting(name: String, from : String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
        Text(
            text = stringResource(R.string.happy_birthday, name),
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        );
        Text(
            text = "from $from",
            fontSize = 36.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        );
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Amir", from = "Mohsen")
    }
}