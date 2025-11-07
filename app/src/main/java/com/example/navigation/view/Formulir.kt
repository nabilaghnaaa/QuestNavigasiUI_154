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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    OnSubmitBtnClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.nama_lengkap), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                label = { Text("Nama Lengkap") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp)
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            Row {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = false,
                            onClick = {}
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
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
