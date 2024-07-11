package com.doga.shoppingcardassignmentsystem.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.doga.shoppingcardassignmentsystem.data.model.entity.CardEntity

@Dao
interface CardDao {

    @Insert
    suspend fun insertCard(card: CardEntity)

    @Query("DELETE FROM cards WHERE productId = :productId")
    suspend fun deleteCard(productId: Int)

    @Query("SELECT * FROM cards WHERE cardDateTime = :cartDateTime")
    suspend fun getCardsByDateTime(cartDateTime: String): List<CardEntity>

    @Query("SELECT * FROM cards")
    suspend fun getAllCards(): List<CardEntity>
}