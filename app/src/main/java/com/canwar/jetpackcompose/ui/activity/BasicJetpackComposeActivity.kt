package com.canwar.jetpackcompose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.canwar.jetpackcompose.ui.activity.ui.theme.JetpackComposeTheme

class BasicJetpackComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    MyApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

// menggunakan kembali composable
@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    // membuat column
    Column(
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        // android compose list
        for (name in names) {
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    // menyimpan state perubahan ketika onClick dan mengingat statusnya
    val expanded = remember { mutableStateOf(false) }

    // menambahkan extra padding
    // extra padding tidak perlu dilakukan remmeber karena bergantung pada value lain
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    // dengan menggunakan materialTheme warna text juga berubah menjadi onPrimary
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        // membuat baris
        Row(modifier = Modifier.padding(24.dp)) {
            // membuat column
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }

            // membuat elevatedButton
            // saat onClick akan memicu rekomposisi
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(text = if (expanded.value) "Show less" else " Show more")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        MyApp()
    }
}