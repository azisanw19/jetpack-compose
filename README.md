# Belajar Jetpack Compose

## Tutorial awal Jetpack Compose

1. Composable function
    - Add Text Element
    - Fungsi composable hanya dapat dipanggil dari fungsi composable lain
    - Anotasi preview digunakan untuk melihat pratinjau 
    - Anotasi preview hanya dapat digunakan pada fungsi composable yang tidak menggunakan parameter

2. Tata Letak
   - Bersifat hierarkis, dengan eleman satu berada dalam elemen lainnya
   - Membuild ui dengan fungsi compose
   - `Column` mengatur elemen secara vertikal
   - `Row` mengatur elemen secara horizontal
   - `Box` untuk menumpuk elemen
   - Menambahkan elemen gambar
   - `Modifier` digunakan untuk konfigurasi tata letak dapat digunakan untuk konfigurasi ukuran, tata letak, tampilan atau interaksi elemen tingkat lebih tinggi seperti membuat elemen menjadi dapat diklik
   - `Spacer` digunakan untuk menambahkan space kosong

3. Desain Material
   - Android compose mendukung material desain
   - Menggunakan Material Desain untuk style dan warna
   - `Shape` digunakan untuk menambahkan bentuk
   - `Preview` dengan mode gelap

4. Daftar dan animasi
   - `items` digunakan untuk membuat list pada android compose
   - `lazyColumn` atau `lazyRow` hanya dirender ketika elemen terlihat di layar
   - `remember` digunakan menyimpan status lokal dalam memori 
   - `mutableStateOf` digunakan untuk memantau perubahan pada nilai
   - Dengan menggunakan `remember` dan `mutableStateOf` perubahan apapun pada status akan otomatis memperbarui UI
   - `animateColorAsState` digunakan untuk mengubah color dan animate
   - `animateContentSize` digunakan untuk mengubah ukuran content dan animate

## Dasar-dasar Jetpack Compose

1. Menyesuaikan UI   
2. Menggunakan kembali composable menghindari duplikasi code
3. Membuat baris dan kolom
4. State compose
   - Compose mengubah data menjadi UI dengan memanggil fungsi composable
   - Jika data berubah compose akan menjalankan ulang fungsi composable dengan data baru, hal ini disebut rekomposisi
   - Compose hanya melihat data apa yang diperlukan oleh setiap composable sehingga hanya perlu merekomposisi komopnene yang data nya berubah
   - Fungsi composable dapat sering dijalankan dan dalam urutan apa pun
   - Composable tidak bergantung urutan eksekusi kode atau frekuensi fungsi composable akan direkomposisi
   - `mutableStateOf` dapat membuat compose merekomposisi fungsi yang membaca state
   - State dan mutableState adalah antarmuka yang menyimpan beberapa nilai dan memicu update UI (rekomposisi) setiap nilai tersebut berubah
   - Rekomposisi dapat terjadi kapan saja sehingga anda tidak dapat menetapkan mutableStateOf ke variabel di dalam composable
   - Untuk mempertahankan state, ingat state menggunakan `remember`
   - `remember` digunakan untuk menjaga dari rekomposisi, sehingga status tidak direset

5. State Hoisting
   - `by` adalah delegasi properti agar tidak perlu mengetikkan .value
   - Compose tidak menyembunyikan UI, tetapi tidak menambahkannya ke komposisi sehingga tidak ditambahkan ke hierarki UI yang dihasilkan compose dilakukan menggunakan logika kotlin sederhana
   - Callback adalah fungsi yang diteruskan sebagai argumen ke fungsi lainnya dan dijalankan saat peristiwa terjadi
   - dengan meneruskan fungsi Callback bukan status onBoardingScreen, membuat Composable dapat digunakan kembali dan melindungi state agar tidak diubah oleh Composable lain

6. LazyList Performa lebih baik
   - `LazyColumn` dan `LazyRow` hanya merender item yang terlihat di screen sehingga meningkatkan performa
   - `Items` elemen yang disediakan `LazyColumn` dan `LazyRow` tempat logika rendering setiap elemen
   - Tidak seperti RecyclerView `LazyColumn` tidak mendaur ulang turunannya. Composable baru akan ditampilkan saat dilakukan scroll

7. Mempertahankan State
   - Fungsi `remember` hanya berfungsi selama composable disimpan dikomposisi
   - Saat melakukan rotasi, seluruh aktivitas dimuat ulang, sehingga semua state hilang
   - Hal ini juga terjadi saat perubahan konfigurasi dan penghentian proses
   - `rememberSaveable` setiap perubahan konfigurasi state yang masih ada dan pengehentian proses akan disimpan

8. Menganimasikan
   - `animateDpAsState` adalah salah satu API tingkat rendah
   - API animasi lain dapat dilihat pada [Dokumentasi](https://developer.android.com/jetpack/compose/animation?hl=id)
   - `Spring` dapat digunakan untuk menyesuaikan animasi

9. Style dan Theme
   - Menggunakan prinsip desain [material](https://m3.material.io/)

10. Sentuhan Akhir
   - Membuat lebih menarik

## Bermigrasi ke Jetpack Compose

1. Strategi migrasi
   - Membuat fitur baru dengan compose 
   - Saat membuat fitur, identifikasi elemen yang dapat digunakan kembali dan mulai buat library komponen UI umum
   - Ganti fitu yang ada di satu layar dalam satu waktu

2. Noted
   - Compose akan terhapus setiap kali compose view lepas dari jendela
   - Pada fragments hal ini tidak diinginkan karena komposisi harus mengikuti siklus proses tampilan fragmen untuk jenis view guna menyimpan status dan compose view akan berada dalam status terpisah, namun elemen UI compose akan terlihat saat transisi
   - dapat dimodifikasi dengan `setViewCompositionStrategy` sehingga dapat mengikuti lifecycle fragments
   - untuk menggunakan thema yang ada xml file dapat digunakan library [Accompanist Material Theme Adapter](https://github.com/google/accompanist/tree/main/themeadapter-material) MdcTheme akan membaca theme MDC konteks host dan meneruskannya ke MaterialTheme

## Basics Layout Jetpack Compose

1. Mulai dengan rencana
   - Menganalisis desain, membagi UI menjadi beberapa bagian yang dapat digunakan kembali
   
2. SearchBar
   - Praktek terbaik composable membuat parameter `Modifier` hal ini memungkinkan pemanggil fungsi untuk mengubah tampilan dan nuansa composable yang membuatnya lebih fleksible dan dapat digunakan kembali
   - `TextField` digunakan untuk menerima input berupa teks
   - `Modifier` dapat digunakan untuk 
      - mengubah tata letak, behaviour, tampilan composable
      - menambahkan informasi, seperti label aksesibilitas
      - memproses input user
      - menambahkan integrasi tingkat tinggi, seperti elemen dapat diklik, discroll, ditarik atau dizoom
   - `Modifier.heightIn` digunakan untuk memastikan composable memiliki minimum tinggi tertentu, pendekatan ini direkomendasikan karena kolom masih bisa bertambah besar ketika user meningkatkan ukuran font di settings system
   - `Modifier.fillMaxWidth` digunakan untuk mengisi semua ruang kosong horizontal
   - Dalam `TextField` berisi parameter `leadingIcon` yang menerima composable lain
   - `leadingIcon` tidak memerlukan `contentDescription` karena placeholder `TextField` sudah menjelaskan arti kolom teks
   - Untuk menyesuaikan warna dapat digunakan properti `colors`

3. Align Your Body
   - `contentDescription` dibuat null karena gambar ini bersifat dekoratif, teks dibawah gambar menjelaskan maknanya
   - `Alignment` digunakan untuk perataan content
   - `paddingFromBaseline` digunakan untuk membuat padding dari baseline

4. Favorite Collection Card
   - `Surface` adalah permukaan yang dapat dimodifikasi

5. Align Your Body Row
   - Turunan `LazyRow` bukan composable, sebagai gantinya dapat menggunakan DSL slow list yang menyediakan metode `item` dan `items` yang memunculkan sebagai daftar item
   - `contentPadding` tetap men-scroll konten dalam batas daftar parent tanpa memotongnya

6. Favorite Collections Grid
   - `LazyHorizontalGrid` digunakan untuk memetakan elemen secara horizontal dengan beberapa grid

7. Home Section
   - API Slot adalah sebuah pola yang dibuat compose untuk menghadirkan lapisan penyesuaian diatas composable 
   - membuat komponen lebih fleksible karena menerima elemen turunan yang dapat mengonfigurasi sendiri
   - slot memberikan ruang kosong UI untuk diisi developer sesuai keinginan, contoh slot `TopAppBar`

8. Home Screen
   - Lazy digunakan jika memiliki banyak elemen dalam daftar atau dataset besar untuk dimuat
   - `verticalScroll` memerlukan `ScrollState` yang digunakan untuk mengubah status scroll dari luar
   - `rememberScrellState` dapat digunakan jika tidak ingin mengubah status scroll dari luar

9. Bottom Navigation
   - Dokumentasi sistem desain Jetpack Compose dapat dilihat pada [dokumentasi thema](https://developer.android.com/jetpack/compose/themes?hl=id)

10. MySoothe App
    - `Scaffold` composable tingkat atas yang dapat dikonfigurasi, digunakan untuk berbagai komponen dan elemen layar lainnya seperti topBar, bottomBar

11. Remember Text Field

## State dalam Jetpack Compose

1. State
   - State aplikasi adalah nilai yang dapat berubah dari waktu ke waktu

2. Event
   - Event adalah input yang dihasilkan dari luar atau dari dalam aplikasi

3. Memori dalam Composable
   - Dengan menggunakan `state` dan `mutableStateOf` compose dapat direkomposisi setelah perubahan state
   - rekomposisi dengan `remember` membuat state tidak diinisialisasi kembali
   - `remember` dan `mutableStateOf` digunakan secara bersama-sama dalam composable
   - Ada beberapa cara yang setara seperti yang ditampilkan pada [dokumentasi State Compose](https://developer.android.com/jetpack/compose/state?hl=id#state-in-composables)
   - `LiveData`, `StateFlow`, `Flow` dan `Observable` Rx Java dapat digunakan untuk merekomposisi dengan memetakannya ke State<T>
   - Ada fungsi ekstensi yang didesain untuk merubah state terdapat pada [Compose dan library lainnya](https://developer.android.com/jetpack/compose/state?hl=id#state-in-composables)

4. UI Berbasis State
   - `Composable` dapat dipanggil berdasarkan if sehingga `Composable` dapat membentuk UI atau tidak sesuai kebutuhan
   - Untuk memeriksa layout aplikasi yang dibuat oleh compose dapat menggunakan [Layout Inspector Android Studio](https://developer.android.com/studio/debug/layout-inspector?hl=id)
   - State mendorong elemen mana yang ditampilkan pada UI

5. Remember dalam Compose
   - `remember` menyimpan objek dalam composable dan melupakan initial value ketika rekomposisi
   - Jika komposisi tidak dipanggil dalam rekomposisi berikutnya `remember` yang didalam komposisi akan dilupakan karena tidak dipanggil sehingga akan tereset

## Tema Jetpack Compose

1. Penerapan Tema Material
   - Tema material terdiri dari warna, tipografi, dan bentuk dapat dipelajari pada [Material 2](https://m2.material.io/) dan [material 3](https://m3.material.io/)
   - Material ditetapkan secara default dengan skema warna ungu, tipografi Roboto dan bentuk yang sedikit membulat.

2. Menentukan Tema
   - Untuk mengonversi warna dari format `#dd0d3c`, ganti `#` dengan `0xff` yaitu `Color(0xffdd0d3c)` dengan `ff` berarti alfa penuh
   - Saat menentukan warna, lebih baik menggunakan nilai warna mis Red500 bukan primary. Dengan ini menentukan beberapa tema dapat dimungkinkan, mis warna lain mungkin dianggap primary dalam tema gelap atau pada layar dengan gaya yang berbeda
   - Jika tidak memiliki warna utama dan sekunder yang terpisah, tidak masalah untuk menyediakan warna yang sama untuk keduanya
   - Typografi
   - Shape
   - Dark Mode

3. Handling Color
   - Compose menggunakan class `Color` untuk memberi warna
   - Hardcode color tidak mendukung berbagai tema terang/gelap
   - Pendekatan yang lebih fleksible dengan cara mengambil warna dari tema
   - Component menerima sepasang `color` dan `contentColor`
   - `contentColorFor` mengambil warna yang sesuai untuk warna tema, misalnya background `primary` akan menampilkan `onPrimary` pada `contentColor`
   - Default `MaterialTheme` menggunakan sepasang warna, misalnya `primary` dan `onPrimary`, `error` dan `onError`
   - `LocalContentColor` `CompositionLocal` untuk mengambil warna yang kontras dengan latar belakang yang sedang digunakan
   - Ketika menetapkan warna elemen apa pun, sebaiknya gunakan `Surface` untuk melakukan hal ini karena menetapkan warna konten yang sesuai untuk nilai `CompositionLocal`
```kotlin
-Row(Modifier.background(MaterialTheme.colors.primary)) {}
+Surface(color = MaterialTheme.colors.primary) { 
   +Row()
}
```
   - Material menyarankan berbagai level opasitas `alpha` untuk menyatakan level nilai penting yang berbeda
   - Jetpack Compose menggunakan level opasitad melalui `LocalContentAlpha`
   - Dalam tema gelap, permukaan dengan elevasi lebih tinggi menerima overlay elevasi (latar belakangnya akan lebih terang)
   - Desain material menyarankan untuk menghindari area luas dengan warna cerah pada tema gelap
   - Pola umum adalah memberi warna `primary` pada penampung dalam tema terang dan warna `surface` pada tema gelap

4. Handling Teks
   - `Text` untuk menampilkan text
   - `TextField` dan `OutlinedTextField` untuk input teks
   - `TextStyle` untuk menerapkan gaya teks
   - `AnnotatedString` untuk menerapkan beberapa ga teks
   - Dibalik layar composable `ProvideTextStyle` yang menggunakan `CompositionLocal` menyetel `TextStyle`
   - Jika perlu menerapkan beberapa style ke beberapa teks, dapat menggunakan class `AnnotatedString` untuk menerapkan markup, dengan menambahkan SpanStyle ke berbagai teks.

5. Handling Shape

6. Eksplisit
   - Compose tidak menawarkan cara yang eksplisit untuk mengekstrak gaya komponen seperti gaya Android View atau haya css.
   - Ada cara lain untuk mencapai sasaran yang sama dengan membuat library komponen kustom sendiri dan gunakan di seluruh aplikasi

# Layout, Theme, and, Animation

1. Deep dive into Jetpack Compose Layouts
   - Jetpack transform state ke UI dari Composition -> Layout -> Drawing
   - Menggunakan Skema Tree