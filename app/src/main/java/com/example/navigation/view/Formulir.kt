package com.example.Navigation.view // Mendefinisikan package tempat file ini berada

import androidx.compose.foundation.layout.* // Import untuk layout seperti Column, Row, padding, dll
import androidx.compose.material3.* // Import untuk komponen Material 3 (Button, TextField, dsb)
import androidx.compose.runtime.Composable // Import untuk menandai fungsi Compose
import androidx.compose.ui.Alignment // Import untuk pengaturan alignment (posisi)
import androidx.compose.ui.Modifier // Import untuk modifier (mengatur ukuran, padding, dsb)
import androidx.compose.ui.graphics.Color // Import untuk warna
import androidx.compose.ui.res.colorResource // Import untuk mengambil warna dari resource
import androidx.compose.ui.res.stringResource // Import untuk mengambil string dari resource
import androidx.compose.ui.unit.dp // Import untuk ukuran berbasis dp
import com.example.navigation.R // Import resource dari folder res (misalnya warna, string, dll)

@OptIn(ExperimentalMaterial3Api::class) // Mengizinkan penggunaan API eksperimental dari Material3
@Composable // Menandakan bahwa ini adalah fungsi UI Jetpack Compose
fun FormIsian( // Membuat fungsi composable bernama FormIsian
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"), // Parameter daftar jenis kelamin
    OnSubmitBtnClick: () -> Unit // Parameter callback untuk tombol submit
) {
    Scaffold( // Struktur dasar halaman dengan TopBar dan konten utama
        modifier = Modifier, // Modifier kosong (tidak ada perubahan)
        topBar = { // Bagian untuk membuat TopBar
            TopAppBar( // Membuat AppBar di bagian atas
                title = { Text(text = stringResource(id = R.string.nama_lengkap), color = Color.White) }, // Judul di AppBar dengan warna putih
                colors = TopAppBarDefaults.mediumTopAppBarColors( // Mengatur warna background AppBar
                    containerColor = colorResource(id = R.color.teal_700) // Mengambil warna dari resource teal_700
                )
            )
        }

    ) { isiRuang -> // isiRuang adalah padding otomatis dari Scaffold
        Column( // Membuat layout vertikal
            modifier = Modifier
                .padding(isiRuang) // Memberikan padding sesuai Scaffold
                .fillMaxSize(), // Mengisi seluruh layar
            verticalArrangement = Arrangement.Top, // Mengatur posisi vertikal di atas
            horizontalAlignment = Alignment.CenterHorizontally // Mengatur agar isi berada di tengah horizontal
        ) {
            OutlinedTextField( // Input teks dengan border
                value = "", // Nilai input (kosong)
                onValueChange = {}, // Fungsi ketika teks berubah (belum diatur)
                singleLine = true, // Input hanya satu baris
                label = { Text("Nama Lengkap") }, // Label di atas input
                modifier = Modifier
                    .padding(top = 20.dp) // Jarak dari atas
                    .width(250.dp) // Lebar text field 250dp
            )

            HorizontalDivider( // Garis horizontal pemisah
                modifier = Modifier
                    .padding(20.dp) // Memberikan jarak dari sekitar garis
                    .width(250.dp), // Lebar garis 250dp
                thickness = 1.dp, // Ketebalan garis 1dp
                color = Color.Red // Warna garis merah
            )

            Row { // Layout horizontal untuk radio button
                jenisK.forEach { item -> // Melakukan iterasi untuk setiap item di list jenisK
                    Row(verticalAlignment = Alignment.CenterVertically) { // Menyusun radio button dan teks sejajar vertikal
                        RadioButton( // Komponen radio button
                            selected = false, // Tidak ada yang dipilih (default)
                            onClick = {} // Aksi ketika diklik (belum diatur)
                        )
                        Text(text = item) // Menampilkan teks “Laki-laki” atau “Perempuan”
                    }
                }
            }

            HorizontalDivider( // Garis pembatas lagi
                modifier = Modifier
                    .padding(20.dp) // Padding sekitar garis
                    .width(250.dp), // Lebar 250dp
                thickness = 1.dp, // Ketebalan 1dp
                color = Color.Red // Warna merah
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                label = { Text("Alamat") },
                modifier = Modifier.width(250.dp)
            )

            Button(
                onClick = OnSubmitBtnClick,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(250.dp)
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}
