package com.doga.shoppingcardassignmentsystem.di

import com.doga.shoppingcardassignmentsystem.data.repositoryimpl.CardRepositoryImpl
import com.doga.shoppingcardassignmentsystem.data.repositoryimpl.ProductRepositoryImpl
import com.doga.shoppingcardassignmentsystem.domain.datasource.CardLocalDataSource
import com.doga.shoppingcardassignmentsystem.domain.datasource.ProductLocalDataSource
import com.doga.shoppingcardassignmentsystem.domain.repository.CardRepository
import com.doga.shoppingcardassignmentsystem.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(
        productLocalDataSource: ProductLocalDataSource
    ): ProductRepository = ProductRepositoryImpl(productLocalDataSource)

    @Provides
    @Singleton
    fun provideCardRepository(
        cardLocalDataSource: CardLocalDataSource
    ): CardRepository = CardRepositoryImpl(cardLocalDataSource)

}