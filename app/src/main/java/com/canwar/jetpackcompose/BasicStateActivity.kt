package com.canwar.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.canwar.jetpackcompose.ui.theme.JetpackComposeTheme

class BasicStateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    WellnessScreen()
                    WaterCounterRemember()
                }
            }
        }
    }
}

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        // rekomposisi akan dilakukan dengan baik namun variable count akan diinisialisasi ulang
//        var count: MutableState<Int> = mutableStateOf(0)
        // rekomposisi dengan remember membuat state tidak diinisialisasi kembali
        /*var count: MutableState<Int> = remember {
            mutableStateOf(0)
        }*/
        // menggunakan delegasi `by` memungkinkan membuat pemanggilan tanpa menggunakan value
        var count by remember {
            mutableStateOf(0)
        }

        Text(
            text = "You've had $count glasses.",
        )

        Button(
            onClick = { count++ },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Add one")
        }

    }

}

@Composable
fun WaterCounterCondition(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        var count by remember {
            mutableStateOf(0)
        }

        if (count > 0) {
            Text(
                text = "You've had $count glasses.",
            )
        }

        Button(
            onClick = { count++ },
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Add one")
        }

    }

}

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier
) {
    WaterCounterCondition(modifier)
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    onColse: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )

        IconButton(
            onClick = onColse
        ) {

            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close"
            )

        }

    }
}

@Composable
fun WaterCounterRemember(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {

        var count by remember {
            mutableStateOf(0)
        }

        // rekomposisi terjadi ketika `count` bertambah
        if (count > 0) {
            var showTask by remember {
                mutableStateOf(true)
            }

            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    // rekomposisi terjadi ketika `showTask` berubah
                    onColse = { showTask = false }
                )
            }
            Text(
                text = "You've had $count glasses."
            )
        }

        Row(
            modifier = Modifier.padding(top = 8.dp)
        ) {

            Button(
                // setelah di reset ke 0 `WellnessTaskItem` akan ditampilkan kembali, karena nilai `showTask` sebelumnya dilupakan
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text(text = "Add one")
            }

            Button(
                // `count` kembali ke 0 memicu rekompoisi
                // semua kode yang terkait dengan `WellnessTaskItem` tidak dipanggil dan keluar dari komposisi
                // `showTask` dilupakan karena lokasi tempat `showTask` remember dipanggil, tidak dipanggil.
                // kembali ke step awal
                onClick = { count = 0 },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Clear water count")
            }

        }


    }
}