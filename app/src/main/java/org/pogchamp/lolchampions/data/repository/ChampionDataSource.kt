package org.pogchamp.lolchampions.data.repository

import org.pogchamp.lolchampions.data.api.ChampionApi
import org.pogchamp.lolchampions.data.model.ChampionResponse
import org.pogchamp.lolchampions.domain.model.Champion
import org.pogchamp.lolchampions.presentation.exception.EmptyBodyException
import org.pogchamp.lolchampions.presentation.exception.NetworkErrorException
import javax.inject.Inject

interface ChampionDataSource {
    suspend fun getChampion(): ChampionResponse<Champion>
}

class ChampionDataSourceImpl @Inject constructor(
    private val championApi: ChampionApi
) : ChampionDataSource {
    override suspend fun getChampion(): ChampionResponse<Champion> {
        val response = championApi.getChampion()
        if (response.isSuccessful) {
            return response.body()
                ?: throw EmptyBodyException("[${response.code()}] : ${response.raw()}")
        } else throw NetworkErrorException("[${response.code()}] : ${response.raw()}")
    }
}