package org.pogchamp.lolchampions.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import org.pogchamp.lolchampions.domain.model.Champion
import org.pogchamp.lolchampions.domain.usecase.GetChampionUseCase
import org.pogchamp.lolchampions.presentation.base.UiState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getChampionUseCase: GetChampionUseCase
) : ViewModel() {
    val uiState: StateFlow<UiState<List<Champion>>> = getChampionUseCase.execute(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = UiState.Loading
    )
}