package org.pogchamp.lolchampions.data.repository

import org.pogchamp.lolchampions.data.api.ChampionApi
import org.pogchamp.lolchampions.data.model.ChampionInfo
import org.pogchamp.lolchampions.data.model.ChampionResponse
import org.pogchamp.lolchampions.presentation.exception.EmptyBodyException
import org.pogchamp.lolchampions.presentation.exception.NetworkErrorException
import javax.inject.Inject

interface ChampionInfoDataSource {
    suspend fun getChampionInfo(id: String): ChampionResponse<ChampionInfo>
}

class ChampionInfoDataSourceImpl @Inject constructor(
    private val championApi: ChampionApi
) : ChampionInfoDataSource {
    override suspend fun getChampionInfo(id: String): ChampionResponse<ChampionInfo> {
        val response = championApi.getChampionInfo(id)
        if (response.isSuccessful) {
            return response.body()
                ?: throw EmptyBodyException("[${response.code()}] : ${response.raw()}")
        } else throw NetworkErrorException("[${response.code()}] : ${response.raw()}")
    }
}