package org.pogchamp.lolchampions.data.api

import org.pogchamp.lolchampions.data.model.ChampionInfo
import org.pogchamp.lolchampions.data.model.ChampionResponse
import org.pogchamp.lolchampions.domain.model.Champion
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ChampionApi {
    @GET("data/en_US/champion.json")
    suspend fun getChampion(): Response<ChampionResponse<Champion>>

    @GET("data/en_US/champion/{id}.json")
    suspend fun getChampionInfo(@Path("id") id: String): Response<ChampionResponse<ChampionInfo>>
}