package com.example.praktikum6.ui.viewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.DataMahasiswa

class MahasiswaViewModel {
    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState : StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(listDM: List<String>){
        _uiState.update { datamhs ->
            datamhs.copy(
                nama = listDM[0],
                gender = listDM[1],
                alamat = listDM[2],
                nim = listDM[3]
            )
        }
    }
}