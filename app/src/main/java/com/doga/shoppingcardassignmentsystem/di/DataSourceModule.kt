package com.doga.shoppingcardassignmentsystem.di

import com.doga.shoppingcardassignmentsystem.data.source.dao.CardDao
import com.doga.shoppingcardassignmentsystem.data.source.dao.ProductDao
import com.doga.shoppingcardassignmentsystem.data.source.datasourceimpl.CardLocalDataSourceImpl
import com.doga.shoppingcardassignmentsystem.data.source.datasourceimpl.ProductLocalDataSourceImpl
import com.doga.shoppingcardassignmentsystem.domain.datasource.CardLocalDataSource
import com.doga.shoppingcardassignmentsystem.domain.datasource.ProductLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideProductLocalDataSource(
        productDao: ProductDao,
        ioDispatcher: CoroutineContext
    ): ProductLocalDataSource = ProductLocalDataSourceImpl(productDao, ioDispatcher)

    @Provides
    @Singleton
    fun provideCardLocalDataSource(
        cardDao: CardDao,
        ioDispatcher: CoroutineContext
    ): CardLocalDataSource = CardLocalDataSourceImpl(cardDao, ioDispatcher)
}