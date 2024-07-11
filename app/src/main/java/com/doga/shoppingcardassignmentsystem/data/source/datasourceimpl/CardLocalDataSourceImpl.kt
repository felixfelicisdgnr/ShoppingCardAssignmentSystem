package com.doga.shoppingcardassignmentsystem.data.source.datasourceimpl

import com.doga.shoppingcardassignmentsystem.data.model.entity.CardEntity
import com.doga.shoppingcardassignmentsystem.data.source.dao.CardDao
import com.doga.shoppingcardassignmentsystem.domain.datasource.CardLocalDataSource
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CardLocalDataSourceImpl @Inject constructor(
    private val cardDao: CardDao,
    private val ioDispatcher: CoroutineContext
) : CardLocalDataSource {
    override suspend fun insertCard(card: CardEntity) = withContext(ioDispatcher) {
        cardDao.insertCard(card)
    }

    override suspend fun deleteCard(productId: Int)  = withContext(ioDispatcher) {
        cardDao.deleteCard(productId)
    }

    override suspend fun getCardsByDateTime(cartDateTime: String): List<CardEntity> = withContext(ioDispatcher) {
        cardDao.getCardsByDateTime(cartDateTime)
    }

    override suspend fun getAllCards(): List<CardEntity> = withContext(ioDispatcher) {
        cardDao.getAllCards()
    }
}