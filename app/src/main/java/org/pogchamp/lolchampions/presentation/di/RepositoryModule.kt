package org.pogchamp.lolchampions.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.pogchamp.lolchampions.data.repository.ChampionInfoRepositoryImpl
import org.pogchamp.lolchampions.data.repository.ChampionRepositoryImpl
import org.pogchamp.lolchampions.domain.repository.ChampionInfoRepository
import org.pogchamp.lolchampions.domain.repository.ChampionRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindChampionRepository(championRepositoryImpl: ChampionRepositoryImpl): ChampionRepository

    @Singleton
    @Binds
    abstract fun bindChampionInfoRepository(championInfoRepositoryImpl: ChampionInfoRepositoryImpl): ChampionInfoRepository
}