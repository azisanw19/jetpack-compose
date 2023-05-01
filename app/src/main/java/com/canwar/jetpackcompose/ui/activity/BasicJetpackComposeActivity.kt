package com.canwar.jetpackcompose.ui.activity

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.canwar.jetpackcompose.ui.theme.JetpackComposeTheme

class BasicJetpackComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    MyApp(modifier = Modifier.fillMaxSize())
//                    LazyColumnExample(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

// menggunakan kembali composable
@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "Android" }
) {
    // membuat column
    LazyColumn(
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        // android compose list
        items(items = names) { name ->
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    // menyimpan state perubahan ketika onClick dan mengingat statusnya
    // ketika dilakukan scroll hingga screen menutupi list dapat dilihat expanded state kembali ke default false
    // untuk mengubahnya dapat menggunakan `rememberSaveable`
    val expanded = remember { mutableStateOf(false) }

    // menambahkan extra padding
    // extra padding tidak perlu dilakukan remmeber karena bergantung pada value lain
    // menambahkan animasi
    val extraPadding by animateDpAsState(
        targetValue = if (expanded.value) 48.dp else 0.dp,
        label = "extra padding",
        // menyesuaikan animasi
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    // dengan menggunakan materialTheme warna text juga berubah menjadi onPrimary
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        // membuat baris
        Row(modifier = Modifier.padding(24.dp)) {
            // membuat column
            Column(
                modifier = Modifier
                    .weight(1f)
                    // memastikan padding tidak pernah negatid
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello,")
                Text(
                    text = name,
                    // menggunakan materialTheme style
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }

            // membuat elevatedButton
            // saat onClick akan memicu rekomposisi
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(text = if (expanded.value) "Show less" else " Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
// Menambahkan preview dark mode
@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        MyApp(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    // dengan menggunakan `rememberSaveable` setiap perubahan konfigurasi seperti rotasi dan penghentian proses akan disimpan
    var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnBoarding) {
            // dengan meneruskan fungsi bukan status onBoardingScreen, membuat Composable dapat digunakan kembali dan melindungi state agar tidak diubah oleh Composable lain
            OnboardingScreen(onContinueClicked = {
                shouldShowOnBoarding = false
            })
        } else {
            Greetings()
        }
    }

}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Composable
fun LazyColumnExample(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "Lazy" }
) {

    // `LazyColumn` dan `LazyRow` hanya merender item yang terlihat di screen sehingga meningkatkan performa
    // `Items` elemen yang disediakan `LazyColumn` dan `LazyRow` tempat logika rendering setiap elemen
    // Tidak seperti RecyclerView `LazyColumn` tidak mendaur ulang turunannya. Composable baru akan ditampilkan saat dilakukan scroll
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }

}