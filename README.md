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
   - Column mengatur elemen secara vertikal
   - Row mengatur elemen secara horizontal
   - Box untuk menumpuk elemen
   - Menambahkan elemen gambar
   - Modifier digunakan untuk konfigurasi tata letak dapat digunakan untuk konfigurasi ukuran, tata letak, tampilan atau interaksi elemen tingkat lebih tinggi seperti membuat elemen menjadi dapat diklik
   - Spacer digunakan untuk menambahkan space kosong

3. Desain Material
   - Android compose mendukung material desain
   - Menggunakan Material Desain untuk style dan warna
   - Shape digunakan untuk menambahkan bentuk
   - Preview dengan mode gelap

4. Daftar dan animasi
   - items digunakan untuk membuat list pada android compose
   - lazyColumn atau lazyRow hanya dirender ketika elemen terlihat di layar
   - remember digunakan menyimpan status lokal dalam memori 
   - mutableStateOf digunakan untuk memantau perubahan pada nilai
   - Dengan menggunakan remember dan mutableStateOf perubahan apapun pada status akan otomatis memperbarui UI
   - animateColorAsState digunakan untuk mengubah color dan animate
   - animateContentSize digunakan untuk mengubah ukuran content dan animate

## Dasar-dasar Jetpack Compose

1. Menyesuaikan UI   