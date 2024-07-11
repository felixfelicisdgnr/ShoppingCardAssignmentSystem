package com.doga.shoppingcardassignmentsystem.domain.repository

import com.doga.shoppingcardassignmentsystem.data.model.entity.CardEntity

interface CardRepository {

    suspend fun insertCard(card: CardEntity)

    suspend fun deleteCard(productId: Int)

    suspend fun getCardsByDateTime(cartDateTime: String): List<CardEntity>

    suspend fun getAllCards(): List<CardEntity>
}