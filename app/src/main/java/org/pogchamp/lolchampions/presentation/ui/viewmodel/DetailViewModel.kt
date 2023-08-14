package org.pogchamp.lolchampions.presentation.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import org.pogchamp.lolchampions.data.model.ChampionInfo
import org.pogchamp.lolchampions.domain.usecase.GetChampionInfoUseCase
import org.pogchamp.lolchampions.presentation.base.UiState
import org.pogchamp.lolchampions.presentation.base.successOrNull
import org.pogchamp.lolchampions.presentation.ui.view.DetailActivity
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    getChampionInfoUseCase: GetChampionInfoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val championId: String = savedStateHandle.get(DetailActivity.CHAMPION_ID_KEY)
        ?: throw IllegalStateException("Champion id Hilang")

    val championImageUrl: String = savedStateHandle.get(DetailActivity.CHAMPION_IMAGE_URL)
        ?: throw IllegalStateException("Champion image url Tidak Ada")

    val uiState: StateFlow<UiState<ChampionInfo>> = getChampionInfoUseCase.execute(
        id = championId,
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initValue = UiState.Loading
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    val championInfo: StateFlow<ChampionInfo> = uiState.mapLatest { uiState ->
        uiState.successOrNull() ?: ChampionInfo.EMPTY
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = ChampionInfo.EMPTY
    )
}