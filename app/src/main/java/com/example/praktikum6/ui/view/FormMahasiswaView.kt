package com.example.praktikum6.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked : (MutableList<String>) -> Unit
){
    var nama by rememberSaveable{ mutableStateOf("") }
    var alamat by rememberSaveable{ mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val dataMahasiswa : MutableList<String> = mutableStateListOf(nama, gender, alamat)
   

    Column (
        Modifier
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

        Row {
            jeniskelamin.forEach{item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = selectedGender == item,
                        onClick = {
                            selectedGender = item
                        })
                    Text(item)
                }

            }

        }

        OutlinedTextField(

            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Email Anda") },
            label = { Text("Email" ) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )
        Button(onClick = { onSubmitClicked(dataMahasiswa)}) {
            
            Text(text = "Simpan")
            
        }

        OutlinedTextField(

            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat Anda") },
            label = { Text("Alamat" ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )

        OutlinedTextField(

            value = nohp,
            onValueChange = {nohp = it},
            placeholder = { Text("Masukkan NoHP Anda") },
            label = { Text("No HP" ) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )





    }


}

