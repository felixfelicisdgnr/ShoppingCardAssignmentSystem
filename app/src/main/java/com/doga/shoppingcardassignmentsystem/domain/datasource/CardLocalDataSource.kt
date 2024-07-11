package com.doga.shoppingcardassignmentsystem.domain.datasource

import com.doga.shoppingcardassignmentsystem.data.model.entity.CardEntity
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity

interface CardLocalDataSource {

    suspend fun insertCard(card: CardEntity)

    suspend fun deleteCard(productId: Int)

    suspend fun getCardsByDateTime(cartDateTime: String): List<CardEntity>

    suspend fun getAllCards(): List<CardEntity>
}