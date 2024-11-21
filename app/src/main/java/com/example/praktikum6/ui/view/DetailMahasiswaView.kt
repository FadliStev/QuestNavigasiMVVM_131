package com.example.praktikum6.ui.view

import android.util.Pair
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import model.DataMahasiswa

@Composable
fun DetailMahasiswaview(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onBackButton :() -> Unit
    ){

    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat),
        Pair("NIM", uiStateMahasiswa.nim),

    )
    Column() {
        listDataMhs.forEach { items ->
            CardSection(judulParam = items.first, isiParam = items.second)
        }
    }
    
    Button(onClick = { onBackButton()}) {
        Text("Kembali")
    }

}


@Composable
fun CardSection(

    judulParam: String,
    isiParam: String

){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(5.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = judulParam,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = " : ",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f)
            )
        }
    }

}