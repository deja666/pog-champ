package org.pogchamp.lolchampions.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.pogchamp.lolchampions.domain.model.Champion
import org.pogchamp.lolchampions.domain.repository.ChampionRepository
import org.pogchamp.lolchampions.presentation.base.UiState
import javax.inject.Inject

class ChampionRepositoryImpl @Inject constructor(
    private val championDataSource: ChampionDataSource
) : ChampionRepository {
    override fun getChampion(): Flow<UiState<List<Champion>>> =
        flow<UiState<List<Champion>>> {
            val list = championDataSource.getChampion().getList()
            emit(UiState.Success(list))
        }.buffer().catch {
            emit(UiState.Error(it))
        }
}