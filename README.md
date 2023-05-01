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