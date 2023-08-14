package org.pogchamp.lolchampions.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.pogchamp.lolchampions.domain.model.Champion
import org.pogchamp.lolchampions.domain.repository.ChampionRepository
import org.pogchamp.lolchampions.presentation.base.UiState
import javax.inject.Inject

class GetChampionUseCase @Inject constructor(private val championRepository: ChampionRepository) {
    fun execute(
        scope: CoroutineScope,
        started: SharingStarted,
        initialValue: UiState<List<Champion>>
    ): StateFlow<UiState<List<Champion>>> =
        championRepository.getChampion().stateIn(scope, started, initialValue)
}