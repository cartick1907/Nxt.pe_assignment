package com.example.nxtpeassignment.viewmodels

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    private val _timer: MutableState<Long> = mutableStateOf(0)
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    val timer: State<Long> get() = _timer

    var showLoadingDialog by mutableStateOf(false)
    var showConfirmationDialog by mutableStateOf(false)


    init{
        viewModelScope.launch {
            _isLoading.value = true
            repository.getData()
            _isLoading.value = false
        }
    }
    val countDownTimer = object : CountDownTimer(21000, 1000L) {
        override fun onTick(millisUntilFinished: Long) {
            _timer.value = millisUntilFinished / 1000
            if (timer.value == 14L) {
                showLoadingDialog = false
                showConfirmationDialog = true
            } else if (timer.value == 8L) {
                showConfirmationDialog = false
                cancel()
            }
        }

        override fun onFinish() {
        }
    }

}