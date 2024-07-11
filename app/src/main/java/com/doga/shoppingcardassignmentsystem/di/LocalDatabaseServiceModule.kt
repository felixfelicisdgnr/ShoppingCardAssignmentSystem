package com.doga.shoppingcardassignmentsystem.di

import android.content.Context
import androidx.room.Room
import com.doga.shoppingcardassignmentsystem.data.source.RoomDatabaseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object LocalDatabaseServiceModule {

    @Provides
    @Singleton
    fun provideLocalDatabaseService(@ApplicationContext appContext: Context): RoomDatabaseService =
        Room.databaseBuilder(
            appContext,
            RoomDatabaseService::class.java,
            "card.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideCardDao(roomDatabaseService: RoomDatabaseService) = roomDatabaseService.getCardDao()

    @Provides
    @Singleton
    fun provideProductDao(roomDatabaseService: RoomDatabaseService) = roomDatabaseService.getProductDao()

}