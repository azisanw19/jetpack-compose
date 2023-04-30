package com.canwar.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MessageCard(name = "Aziz Anwar")
//            MessageCardHierarkis(msg = Message("Aziz Anwar", "Jetpack Compose"))
            MessageCardColumn(msg = Message("Aziz Anwar", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

// Fungsi dengan anotasi Composable hanya dapat dipanggil dari fungsi compose lain
@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}

// Anotasi preview digunakan untuk melihat pratinjau
// Anotasi preview hanya dapat digunakan pada fungsi composable yang tidak menggunakan parameter
@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(name = "Aziz Anwar")
}

// 2 Elemen teks tetapi informasi mengaturnya belum disedikan sehingga saling bertumpuk
@Composable
fun MessageCardHierarkis(msg: Message) {
    Text(text = msg.author)
    Text(text = msg.body)
}

// Column mengatur elemen secara vertical
@Composable
fun MessageCardColumn(msg: Message) {
    Column {
        Text(text = msg.author)
        Text(text = msg.body)
    }
}