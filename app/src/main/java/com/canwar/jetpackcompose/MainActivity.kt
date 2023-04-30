package com.canwar.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MessageCard(name = "Aziz Anwar")
//            MessageCardHierarkis(msg = Message("Aziz Anwar", "Jetpack Compose"))
//            MessageCardColumn(msg = Message("Aziz Anwar", "Jetpack Compose"))
//            MessageCardRow(msg = Message("Aziz Anwar", "Jetpack Compose"))
//            MessageCardBox(msg = Message("Aziz Anwar", "Jetpack Compose"))
            MessageCardImage(msg = Message("Natsume Mio", "Just Because"))
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

// Raw mengatur elemen secara horizontal
@Composable
fun MessageCardRow(msg: Message) {
    Row {
        Text(text = msg.author)
        Text(text = msg.body)
    }
}

// Box untuk menumpuk elemen
@Composable
fun MessageCardBox(msg: Message) {
    Box {
        Text(text = msg.author)
        Text(text = msg.body)
    }
}

// Menambahkan elemen gambar
@Composable
fun MessageCardImage(msg: Message) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.image_photo_profile_natsume_mio),
            contentDescription = "Natsume Mio Photo Profile"
        )
        
        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }
    }
}