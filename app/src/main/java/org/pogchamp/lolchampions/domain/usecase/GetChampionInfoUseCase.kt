package org.pogchamp.lolchampions.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.pogchamp.lolchampions.data.model.ChampionInfo
import org.pogchamp.lolchampions.domain.repository.ChampionInfoRepository
import org.pogchamp.lolchampions.presentation.base.UiState
import javax.inject.Inject

class GetChampionInfoUseCase @Inject constructor(private val championInfoRepository: ChampionInfoRepository) {
    fun execute(
        id: String,
        scope: CoroutineScope,
        started: SharingStarted,
        initValue: UiState<ChampionInfo>
    ): StateFlow<UiState<ChampionInfo>> =
        championInfoRepository.getChampionInfo(id).stateIn(scope, started, initValue)
}