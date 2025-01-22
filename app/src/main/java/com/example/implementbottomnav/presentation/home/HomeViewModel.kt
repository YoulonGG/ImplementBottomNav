package com.example.implementbottomnav.presentation.home

import androidx.lifecycle.viewModelScope
import com.example.implementbottomnav.core.utils.BaseViewModel
import com.example.implementbottomnav.data.dto.response.Result
import com.example.implementbottomnav.data.remote.common.ApiResult
import com.example.implementbottomnav.domain.useCase.NowPlayingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val nowPlayingUseCase: NowPlayingUseCase,
) : BaseViewModel<NowPlayingUiState, NowPlayingAction>() {

    override fun setInitialState(): NowPlayingUiState = NowPlayingUiState()

    override fun onAction(event: NowPlayingAction) {
        when (event) {
            NowPlayingAction.FetchNowPlayingMovie -> getNowPlayingMovie()
        }
    }

    private val _nowPlayingData = MutableStateFlow<List<Result?>>(mutableListOf())
    val nowPlayingData: StateFlow<List<Result?>> =
        _nowPlayingData.onStart {
            getNowPlayingMovie()
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            emptyList()
        )

    private fun getNowPlayingMovie() {
        nowPlayingUseCase.invoke().flowOn(Dispatchers.IO).onEach { result ->
            when (result) {
                is ApiResult.Error -> {
                    setState { copy(isError = true, isLoading = false) }
                }

                is ApiResult.Success -> {
                    _nowPlayingData.update { result.data?.results ?: emptyList() }
                    setState { copy(isError = false, isLoading = false) }
                }

                is ApiResult.Loading -> {
                    setState { copy(isLoading = true, isError = false) }
                }
            }
        }.launchIn(viewModelScope)
    }

}


data class NowPlayingUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = true
)

sealed interface NowPlayingAction {
    data object FetchNowPlayingMovie : NowPlayingAction
}