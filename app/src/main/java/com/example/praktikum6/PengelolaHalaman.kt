package com.example.praktikum6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.praktikum6.ui.view.FormMahasiswaView
import com.example.praktikum6.ui.view.DetailMahasiswaview
import com.example.praktikum6.ui.viewModel.MahasiswaViewModel
import model.DataJenisKelamin


enum class Halaman{
    Formulir,
    Detail,
}
@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    Scaffold { isipadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost,
            startDestination = Halaman.Formulir.name
        ) {
        composable(route = Halaman.Formulir.name){
            val konteks = LocalContext.current

            FormMahasiswaView(
                listJK = DataJenisKelamin.listJK.map{
                id -> konteks.resources.getString(id)
            },
                onSubmitClicked = {
                    viewModel.saveDataMahasiswa(it)
                    navHost.navigate(Halaman.Formulir.name)
                }
                )

            }
            composable(route = Halaman.Detail.name){
                DetailMahasiswaview(
                    uiStateMahasiswa = uiState,
                     onBackButton = { navHost.popBackStack() }
                )
            }
        }
        }
    }


