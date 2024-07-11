package com.doga.shoppingcardassignmentsystem.data.repositoryimpl

import com.doga.shoppingcardassignmentsystem.data.model.entity.CardEntity
import com.doga.shoppingcardassignmentsystem.domain.datasource.CardLocalDataSource
import com.doga.shoppingcardassignmentsystem.domain.repository.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardLocalDataSource: CardLocalDataSource
) : CardRepository {
    override suspend fun insertCard(card: CardEntity) = cardLocalDataSource.insertCard(card)

    override suspend fun deleteCard(productId: Int) = cardLocalDataSource.deleteCard(productId)

    override suspend fun getCardsByDateTime(cartDateTime: String): List<CardEntity> =
        cardLocalDataSource.getCardsByDateTime(cartDateTime)

    override suspend fun getAllCards(): List<CardEntity> = cardLocalDataSource.getAllCards()

}