package com.example.praktikum6.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked : (MutableList<String>) -> Unit
){
    var nama by remember{ mutableStateOf("") }
    var alamat by remember{ mutableStateOf("") }
    var jenisKel by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }

    val dataMahasiswa : MutableList<String> = mutableListOf(nama, jenisKel, alamat, nim)
   

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "BIODATA")

        OutlinedTextField(

            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan Nama Anda") },
            label = { Text("Nama" ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )
        OutlinedTextField(

            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat Anda") },
            label = { Text("Alamat" ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )

        Row {listJK.forEach{item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = jenisKel == item, onClick = { jenisKel = item })
                    Text(item)
                }

            }

        }

        OutlinedTextField(

            value = nim,
            onValueChange = {nim = it},
            placeholder = { Text("Masukkan NIM Anda") },
            label = { Text("NIM" ) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )
        Button(onClick = {
            onSubmitClicked(dataMahasiswa)}) {
            
            Text(text = "Simpan")
            
        }








    }


}

