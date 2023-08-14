package org.pogchamp.lolchampions.domain.repository

import kotlinx.coroutines.flow.Flow
import org.pogchamp.lolchampions.data.model.ChampionInfo
import org.pogchamp.lolchampions.presentation.base.UiState

interface ChampionInfoRepository {
    fun getChampionInfo(id: String): Flow<UiState<ChampionInfo>>
}