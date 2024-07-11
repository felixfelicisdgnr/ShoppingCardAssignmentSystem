package com.doga.shoppingcardassignmentsystem.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CardEntity(
    @PrimaryKey
    @ColumnInfo(name = "productId") val productId: Int,
    @ColumnInfo(name = "cardDateTime") val cardDateTime: String,
    @ColumnInfo(name = "price") val price: Double,
)
