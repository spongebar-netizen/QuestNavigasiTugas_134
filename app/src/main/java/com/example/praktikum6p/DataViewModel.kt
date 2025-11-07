package com.example.praktikum6p
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DataViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DataFormulir())
    val uiState: StateFlow<DataFormulir> = _uiState.asStateFlow()

    fun setNama(nama: String) {
        _uiState.update { currentState -> currentState.copy(nama = nama) }
    }
    fun setAlamat(alamat: String) {
        _uiState.update { currentState -> currentState.copy(alamat = alamat) }
    }
    fun setJenisKelamin(jenisKelamin: String) {
        _uiState.update { currentState -> currentState.copy(jenisKelamin = jenisKelamin) }
    }
    fun setStatus(status: String) {
        _uiState.update { currentState -> currentState.copy(status = status) }
    }
}