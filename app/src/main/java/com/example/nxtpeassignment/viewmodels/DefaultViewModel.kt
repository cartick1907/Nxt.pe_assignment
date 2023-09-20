package com.example.nxtpeassignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nxtpeassignment.models.PageItem
import com.example.nxtpeassignment.repository.mandateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DefaultViewModel @Inject constructor(private val repository: mandateRepository): ViewModel() {

    val pageData : StateFlow<List<PageItem>>
        get() = repository.pageData

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    init{
        viewModelScope.launch {
            _isLoading.value = true
            repository.getData()
            _isLoading.value = false
        }
    }

}