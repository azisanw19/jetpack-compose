package com.canwar.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.canwar.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Menggunakan thema material desain
            JetpackComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
//                    MessageCard(name = "Aziz Anwar")
//                    MessageCardHierarkis(msg = Message("Aziz Anwar", "Jetpack Compose"))
//                    MessageCardColumn(msg = Message("Aziz Anwar", "Jetpack Compose"))
//                    MessageCardRow(msg = Message("Aziz Anwar", "Jetpack Compose"))
//                    MessageCardBox(msg = Message("Aziz Anwar", "Jetpack Compose"))
//                    MessageCardImage(msg = Message("Natsume Mio", "Just Because"))
                    MessageCardConfigurationLayout(msg = Message("Natsume Mio", "Just Because"))
                }
            }
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
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    JetpackComposeTheme {
        Surface {
            MessageCardConfigurationLayout(msg = Message("Natsume Mio", "Just Because"))
        }
    }
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

// Konfigurasi tata letak menggunakan modifier
@Composable
fun MessageCardConfigurationLayout(msg: Message) {
    // Menambahkan Padding di message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.image_photo_profile_natsume_mio),
            contentDescription = "Natsume Mio Photo Profile",
            modifier = Modifier
                // set image size 40 dp
                .size(40.dp)
                // set clip image circle
                .clip(CircleShape)
                // Membuat border
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )

        // add horizontal space
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                // add color
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                // add style
                style = MaterialTheme.typography.headlineMedium
            )
            // add vertical space
            Spacer(modifier = Modifier.height(4.dp))

            // menambahkan shape
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = msg.body,
                    // add padding
                    modifier = Modifier.padding(all = 4.dp),
                    // add style
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}