package org.pogchamp.lolchampions.domain.repository

import kotlinx.coroutines.flow.Flow
import org.pogchamp.lolchampions.domain.model.Champion
import org.pogchamp.lolchampions.presentation.base.UiState

interface ChampionRepository {
    fun getChampion(): Flow<UiState<List<Champion>>>
}