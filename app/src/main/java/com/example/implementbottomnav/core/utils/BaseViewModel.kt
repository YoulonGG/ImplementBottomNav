package com.example.implementbottomnav.core.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState, UiAction>(
    private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    abstract fun setInitialState(): UiState

    abstract fun onAction(event: UiAction)

    private val initialState: UiState by lazy { setInitialState() }

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(initialState)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

//    private val notifyEvents = Channel<NotifyEvents>(capacity = 10)
//    val notifyEventsChannel = notifyEvents.receiveAsFlow()

    protected fun setState(reducer: UiState.() -> UiState) {
        viewModelScope.launch(mainDispatcher) {
            val newState = uiState.value.reducer()
            _uiState.value = newState
        }
    }
}