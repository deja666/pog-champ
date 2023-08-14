package org.pogchamp.lolchampions.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.pogchamp.lolchampions.data.repository.ChampionDataSource
import org.pogchamp.lolchampions.data.repository.ChampionDataSourceImpl
import org.pogchamp.lolchampions.data.repository.ChampionInfoDataSource
import org.pogchamp.lolchampions.data.repository.ChampionInfoDataSourceImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindsChampionDataSource(championDataSourceImpl: ChampionDataSourceImpl): ChampionDataSource

    @Singleton
    @Binds
    abstract fun binsChampionInfoDataSource(championInfoDataSourceImpl: ChampionInfoDataSourceImpl): ChampionInfoDataSource
}