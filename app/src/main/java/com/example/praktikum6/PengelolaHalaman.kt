package com.example.praktikum6

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.praktikum6.ui.view.FormMahasiswaView
import com.example.praktikum6.ui.viewModel.MahasiswaViewModel
import model.DataJenisKelamin


enum class Halaman{
    Formulir,
    Detail,
}
@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel()
){
    val stateUI by viewModel.uiState.collectAsState()

    NavHost(navController = navController, startDestination = Halaman.Formulir.name,){
        composable(route = Halaman.Formulir.name){
            val konteks = LocalContext.current
            FormMahasiswaView(listJk = DataJenisKelamin.listJK.map{id ->
                konteks.resources.getString(
                    id
                )
            },
            onSubmitClicked = {}
                )

        }
    }
}